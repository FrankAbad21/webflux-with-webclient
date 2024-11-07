package com.frab.reactor_webflux.services;

import com.frab.reactor_webflux.models.documents.Notification;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<String> enviarNotification(Mono<Notification> notification);

}
