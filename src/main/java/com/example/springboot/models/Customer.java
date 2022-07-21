package com.example.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    @Column(unique = true)
    private String login;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ROLE> roles = Arrays.asList(ROLE.ROLE_USER);
}
