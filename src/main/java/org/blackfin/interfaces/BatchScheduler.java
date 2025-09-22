package org.blackfin.interfaces;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.blackfin.application.usecase.BatchUseCase;

@ApplicationScoped
public class BatchScheduler {

    @Inject
    BatchUseCase batchUseCase;
    @Inject
    Vertx vertx;

    @Scheduled(every= "60s")
    @WithSession
    public Uni<Void> runBatchJob() {
        Log.info("Iniciando proceso batch...");

        // Explicitly run the reactive chain on a Vert.x event loop thread
        return Uni.createFrom().emitter(emitter ->
                vertx.runOnContext(() -> batchUseCase.run()
                        .subscribe().with(
                                success -> {
                                    Log.info("Proceso batch finalizado con éxito.");
                                    emitter.complete(null);
                                },
                                failure -> {
                                    Log.error("Error en el proceso batch: " + failure.getMessage());
                                    emitter.fail(failure);
                                }
                        ))
        );
    }
}