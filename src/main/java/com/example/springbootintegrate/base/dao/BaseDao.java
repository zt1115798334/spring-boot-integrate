package com.example.springbootintegrate.base.dao;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BaseDao<T> {

    T save(T t);

    Iterable<T> saveAll(Iterable<T> t);

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    Page<T> findPageByEntity(T t);

    void deleteById(Long id);

}
