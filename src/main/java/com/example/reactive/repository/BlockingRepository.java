package com.example.reactive.repository;

import com.example.reactive.model.User;

import java.util.List;

public interface BlockingRepository<T> {
    List<T> findAll();

    void save(User user);
}
