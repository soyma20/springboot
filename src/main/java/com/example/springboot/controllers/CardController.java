package com.example.springboot.controllers;

import com.example.springboot.models.Card;
import com.example.springboot.models.dto.CardUserRequestDTO;
import com.example.springboot.models.dto.CardUserResponseDTO;
import com.example.springboot.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cards")
public class CardController {

    private CardService cardService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveCard(@RequestBody Card card) {
        cardService.save(card);
    }

    @GetMapping("")
    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<>(cardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable int id) {
        return new ResponseEntity<>(cardService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCardByID(@PathVariable int id) {
        cardService.deleteCardById(id);
    }

    @PatchMapping("")
    public ResponseEntity<CardUserResponseDTO> mergeCardAndUser(@RequestBody CardUserRequestDTO dto) {
        return new ResponseEntity<>(cardService.mergeCardAndUser(dto),HttpStatus.OK);
    }


}
