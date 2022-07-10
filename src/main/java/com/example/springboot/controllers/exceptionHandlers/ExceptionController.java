package com.example.springboot.controllers.exceptionHandlers;

import com.example.springboot.models.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> error(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(new ErrorDto(exception, HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

}
