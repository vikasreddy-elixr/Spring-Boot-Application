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
    @NotEmpty
    private String userName;
    @NotEmpty
    private String productName;
    @NotNull
    private Integer amount;
    private LocalDate date = LocalDate.now();
}
