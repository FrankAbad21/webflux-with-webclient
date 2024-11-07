package com.frab.reactor_webflux.controller;

import com.frab.reactor_webflux.models.repository.NotificationRepository;
import com.frab.reactor_webflux.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/api/v1/notification")
@RestController
public class Notification {

    @Autowired
    private NotificationServiceImp notificationRepository;

    public Mono<String> enviarMensaje(@RequestBody Notification notification) {

        return notificationRepository.save()
    }

}
