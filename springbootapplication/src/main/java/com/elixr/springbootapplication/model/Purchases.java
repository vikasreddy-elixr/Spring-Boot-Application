package com.elixr.springbootapplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Document
public class Purchases {
    @Id
    @GeneratedValue
    private String id;
    @NotEmpty(message = "username is mandatory")
    private String userName;
    @NotEmpty(message = "product name is mandatory")
    private String productName;
    @NotNull(message = "amount is mandatory")
    private Integer amount;
    private LocalDate date = LocalDate.now();
}
