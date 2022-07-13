package com.example.springboot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 3, message = "name must be at least 3 chars")
    @Size(max = 40, message = "name must be smaller than 41 chars")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_cards",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards = new ArrayList<>();
    private boolean isActivated = false;
    private String email;

    public User(String name, Passport passport, List<Card> cards) {
        this.name = name;
        this.passport = passport;
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
