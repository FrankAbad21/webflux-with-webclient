package com.frab.reactor_webflux.serviceImp;

import com.frab.reactor_webflux.client.NotificationRequest;
import com.frab.reactor_webflux.models.documents.Notification;
import com.frab.reactor_webflux.services.NotificationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class NotificationServiceImp implements NotificationService {

    private static final String URI = "https://d0c79438-6cd6-488d-9b2c-66d9d742a0e9.mock.pstmn.io";
    private static final String API = "/notifications/mock";


    @Override
    public Mono<String> enviarNotification(Mono<Notification> notification) {
        notification = notification.doOnNext(not -> not.setTimestamp(LocalDateTime.now()));
        Mono<NotificationRequest> notificationRequestMono = notification
                .map(noti -> new NotificationRequest(noti.getUserId(),noti.getMessage()));
        WebClient webClient = WebClient.builder().baseUrl(URI).build();
        webClient.post().uri(API).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(notificationRequestMono, NotificationRequest.class).retrieve()
        return ;
    }
}
