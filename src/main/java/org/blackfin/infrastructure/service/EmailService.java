package org.blackfin.infrastructure.service;

import io.quarkus.logging.Log;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.blackfin.domain.User;

@ApplicationScoped
public class EmailService {

    @Inject
    ReactiveMailer mailer;

    @Inject
    Template notification_template; // Nombre de la plantilla: notification_template.html

    public Uni<Void> sendNotification(User user) {
        String subject = "Notificación importante";
        TemplateInstance templateInstance = notification_template.data("user", user);
        String body = templateInstance.render();
        Log.info("Correo enviado a: " + user.getEmail());
        Mail mail = Mail.withText(user.getEmail(), subject, body);
        return mailer.send(mail);
    }
}
