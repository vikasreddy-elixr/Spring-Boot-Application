package com.elixr.springbootapplication.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Document
public class Purchase {
    @Id
    @GeneratedValue
    private String id;
    @NotEmpty(message = "userName field is Empty or  null")
    private String userName;
    @NotEmpty(message = "product field is Empty or  null")
    private String productName;
    @NotNull(message = "Amount field is Empty or null")
    @Min(value = 0)
    private Integer amount;
    private LocalDate date = LocalDate.now();

}

