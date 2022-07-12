package com.example.springboot.controllers;

import com.example.springboot.dao.PassportDao;
import com.example.springboot.models.Passport;
import com.example.springboot.services.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/passports")
public class PassportController {
    private PassportService passportService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void savePassport(@RequestBody @Valid Passport passport) {
        passportService.save(passport);
    }

    @GetMapping("")
    public ResponseEntity<List<Passport>> getPassports() {
        return new ResponseEntity<>(passportService.getPassports(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable int id) {
        return new ResponseEntity<>(passportService.getPassportById(id), HttpStatus.OK);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePassport(@RequestBody Passport passport) {
        passportService.updatePassport(passport);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePassport(@PathVariable int id) {
        passportService.getPassportById(id);
    }


}
