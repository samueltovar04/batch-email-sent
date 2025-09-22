package org.blackfin.application.usecase;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import org.blackfin.application.port.UserRepository;
import org.blackfin.infrastructure.service.EmailService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BatchUseCase {

    @Inject
    UserRepository userRepository;

    @Inject
    EmailService emailService;

   @WithSession
    public Uni<Void> run() {
        return userRepository.findAll()
                .onItem().call(user -> emailService.sendNotification(user)
                        .onFailure().recoverWithItem(t -> {
                            System.err.println("Error enviando email a " + user.getEmail() + ": " + t.getMessage());
                            return null; // Continuar con el siguiente usuario
                        }))
                .collect().asList() // Recolecta los resultados en una lista
                .replaceWithVoid(); // Y luego reemplaza con void para indicar el fin
    }
}
