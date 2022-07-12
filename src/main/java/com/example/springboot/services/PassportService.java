package com.example.springboot.services;

import com.example.springboot.dao.PassportDao;
import com.example.springboot.models.Passport;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PassportService {
    private PassportDao passportDao;

    public void save(Passport passport) {
        passportDao.save(passport);
    }

    public List<Passport> getPassports() {
        return passportDao.findAll();
    }

    public Passport getPassportById(int id) {
        return passportDao.findById(id).get();
    }

    public void updatePassport(Passport passport){
        passportDao.save(passport);
    }
    public void deletePassport(int id){
        passportDao.deleteById(id);
    }

}
