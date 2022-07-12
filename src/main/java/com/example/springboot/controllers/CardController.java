package com.example.springboot.controllers;

import com.example.springboot.dao.CardDao;
import com.example.springboot.models.Card;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private CardDao cardDao;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveCard(@RequestBody Card card) {
        cardDao.save(card);
    }

    @GetMapping("")
    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<>(cardDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        return new ResponseEntity<>(cardDao.findById(id).get(), HttpStatus.OK);
    }
    @PatchMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCard(@RequestBody Card card){
        cardDao.save(card);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  deleteCardByID(@PathVariable int id){
        cardDao.deleteById(id);
    }

}
