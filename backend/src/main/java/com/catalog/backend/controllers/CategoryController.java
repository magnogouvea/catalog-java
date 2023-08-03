package com.catalog.backend.controllers;

import com.catalog.backend.dtos.CategoryDTO;
import com.catalog.backend.models.CategoryModel;
import com.catalog.backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll() {
    List<CategoryDTO> list = service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
    CategoryDTO dto = service.findById(id);
    return ResponseEntity.status(HttpStatus.OK).body(dto);
  }
}
