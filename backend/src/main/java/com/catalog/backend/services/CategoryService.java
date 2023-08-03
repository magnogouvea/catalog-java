package com.catalog.backend.services;

import com.catalog.backend.dtos.CategoryDTO;
import com.catalog.backend.models.CategoryModel;
import com.catalog.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  @Transactional(readOnly = true)
  public List<CategoryDTO> findAll() {
    List<CategoryModel> list = repository.findAll();

    return list.stream().map(dto -> new CategoryDTO(dto)).collect(Collectors.toList());
  }
}
