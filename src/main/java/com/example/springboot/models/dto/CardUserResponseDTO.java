package com.example.springboot.models.dto;

import com.example.springboot.models.Card;
import com.example.springboot.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardUserResponseDTO {
    private String userName;
    private List<CardNumberDTO> numbersOfCards = new ArrayList<>();

    public CardUserResponseDTO(User user) {
        this.userName = user.getName();
        for (Card card : user.getCards()) {
            this.numbersOfCards.add(new CardNumberDTO(card.getNumber()));
        }
    }
}
