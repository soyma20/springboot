package com.example.springboot.dao;

import com.example.springboot.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportDao extends JpaRepository<Passport, Integer> {
}
