package com.frab.reactor_webflux.models.repository;

import com.frab.reactor_webflux.models.documents.Notification;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NotificationRepository extends ReactiveMongoRepository<Notification, String> {

}
