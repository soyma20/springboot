package com.example.springboot.controllers;

import com.example.springboot.models.User;
import com.example.springboot.models.dto.UserPassportRequestDTO;
import com.example.springboot.models.dto.UserPassportResponseDTO;
import com.example.springboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(@RequestBody @Valid User user) {
        userService.save(user);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }

    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @PatchMapping("")
    public ResponseEntity<UserPassportResponseDTO> mergeUserAndPassport(@RequestBody UserPassportRequestDTO dto) {
        return new ResponseEntity<>(userService.mergeUserAndPassport(dto), HttpStatus.OK);
    }


}
