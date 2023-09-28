package com.example.spring.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users", schema = "spring_databases")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;

    public Users() {
    }

    public Users(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }
}
