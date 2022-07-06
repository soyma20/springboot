package com.example.springboot.controllers;

import com.example.springboot.dao.UserDao;
import com.example.springboot.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserDao userDao;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(@RequestBody User user) {
        userDao.save(user);

    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userDao.findById(id).get(), HttpStatus.OK);
    }
    @PatchMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userDao.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id){
        userDao.deleteById(id);
    }




}
