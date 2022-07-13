package com.example.springboot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 3, message = "series must be at least 3 chars")
    @Size(max = 40, message = "series must be smaller than 41 chars")
    private String series;
    private String photo;

    public Passport(String series, String photo) {
        this.series = series;
        this.photo = photo;
    }
}
