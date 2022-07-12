package com.example.springboot.services;

import com.example.springboot.dao.CardDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.models.Card;
import com.example.springboot.models.User;
import com.example.springboot.models.dto.CardUserRequestDTO;
import com.example.springboot.models.dto.CardUserResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {
    private CardDao cardDao;
    private UserDao userDao;

    public void save(Card card) {
        cardDao.save(card);
    }

    public List<Card> findAll() {
        return cardDao.findAll();
    }

    public Card findById(int id) {
        return cardDao.findById(id).get();
    }

    public void updateCard(Card card) {
        cardDao.save(card);
    }

    public void deleteCardById(int id) {
        cardDao.deleteById(id);
    }
    public CardUserResponseDTO mergeCardAndUser (CardUserRequestDTO dto){
        User user = userDao.findById(dto.getUser_id()).get();
        Card card = cardDao.findById(dto.getCard_id()).get();
        user.addCard(card);
        userDao.save(user);
        return new CardUserResponseDTO(user);
    }

}
