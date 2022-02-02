package com.elixr.training.springboot.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Document(collection = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotEmpty
    @Indexed
    @Column(nullable = false)
    private String userName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

}
