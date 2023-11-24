package com.example.formula1web;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FormModelRepo extends CrudRepository<FormModel, Integer> {
    List<FormModel> findAll();
}