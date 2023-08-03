package com.catalog.backend.services;

import com.catalog.backend.models.CategoryModel;
import com.catalog.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  public List<CategoryModel> findAll() {
    return repository.findAll();
  }
}
