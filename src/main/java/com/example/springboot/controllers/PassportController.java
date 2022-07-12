package com.example.springboot.controllers;

import com.example.springboot.dao.PassportDao;
import com.example.springboot.models.Passport;
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

    private PassportDao passportDao;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void savePassport(@RequestBody @Valid Passport passport) {
        passportDao.save(passport);
    }

    @GetMapping("")
    public ResponseEntity<List<Passport>> getPassports() {
        return new ResponseEntity<>(passportDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable int id) {
        return new ResponseEntity<>(passportDao.findById(id).get(), HttpStatus.OK);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePassport(@RequestBody Passport passport) {
        passportDao.save(passport);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePassport(@PathVariable int id) {
        passportDao.deleteById(id);
    }


}
