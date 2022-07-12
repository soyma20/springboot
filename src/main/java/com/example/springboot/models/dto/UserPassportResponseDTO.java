package com.example.springboot.models.dto;

import com.example.springboot.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPassportResponseDTO {
    private String userName;
    private String passportSeries;

    public UserPassportResponseDTO(User user) {
        this.userName = user.getName();
        this.passportSeries = user.getPassport().getSeries();
    }
}
