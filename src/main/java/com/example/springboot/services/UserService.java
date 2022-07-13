package com.example.springboot.services;

import com.example.springboot.dao.CardDao;
import com.example.springboot.dao.PassportDao;
import com.example.springboot.dao.UserDao;
import com.example.springboot.models.Passport;
import com.example.springboot.models.User;
import com.example.springboot.models.dto.UserPassportRequestDTO;
import com.example.springboot.models.dto.UserPassportResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserDao userDao;
    private PassportDao passportDao;
    private CardDao cardDao;
    private MailService mailService;

    public void save(User user) {
        userDao.save(user);
        mailService.sendEmail(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(int id) {
        return userDao.findById(id).get();
    }

    public void deleteById(int id){
        userDao.deleteById(id);
    }

    public UserPassportResponseDTO mergeUserAndPassport(UserPassportRequestDTO dto){
        User user = userDao.findById(dto.getUser_id()).get();
        Passport passport = passportDao.findById(dto.getPassport_id()).get();
        user.setPassport(passport);
        userDao.save(user);
        return new UserPassportResponseDTO(user);
    }
    public void updateUser(User user){
        userDao.save(user);
    }

    public ResponseEntity<String> activateUser(int id){
        User user = findById(id);
        user.setActivated(true);
        userDao.save(user);
        return new ResponseEntity<>("account activated", HttpStatus.OK);
    }

}
