package com.catalog.backend.controller;

import com.catalog.backend.model.CategoryModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
  @GetMapping
  public ResponseEntity<List<CategoryModel>> findAll() {
    List<CategoryModel> list = new ArrayList<>();
    list.add(new CategoryModel(1L, "Books"));
    return ResponseEntity.status(HttpStatus.OK).body(list);
  }
}
