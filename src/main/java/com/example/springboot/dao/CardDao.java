package com.example.springboot.dao;

import com.example.springboot.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card, Integer> {
}
