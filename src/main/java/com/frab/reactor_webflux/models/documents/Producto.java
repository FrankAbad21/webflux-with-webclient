package com.frab.reactor_webflux.models.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;

    private String name;
    private Double price;
    private Date createAt;

}
