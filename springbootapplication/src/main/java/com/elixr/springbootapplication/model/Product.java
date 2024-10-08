package com.elixr.springbootapplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "products")
public class Product {

    @Id
    @GeneratedValue
    private String id;
    @NotBlank(message = "Product name is a mandatory field cannot be blank")
    private String productName;
    @NotNull(message = "Quantity is a mandatory field")
    @Min(value = 0, message = "Quantity cannot be a negative value")
    private Integer quantity;
    @NotNull(message = "Price is a mandatory field")
    @Min(value = 0, message = "Price cannot be a negative value")
    private Integer price;
    private LocalDateTime date = LocalDateTime.now();
}
