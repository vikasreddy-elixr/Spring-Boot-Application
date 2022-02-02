package com.elixr.springbootapplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Document(collection = "products")
public class Products {

    @Id
    @GeneratedValue
    private String id;
    @NotEmpty
    private String productName;
    @NotEmpty
    private int quantity;
    @NotEmpty
    private int price;
    //@ManyToMany
    //    private Purchases purchases;
    private LocalDateTime localDateAndTime = LocalDateTime.now();

}
