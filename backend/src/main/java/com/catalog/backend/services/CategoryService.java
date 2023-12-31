package com.catalog.backend.services;

import com.catalog.backend.dtos.CategoryDTO;
import com.catalog.backend.models.CategoryModel;
import com.catalog.backend.repositories.CategoryRepository;
import com.catalog.backend.services.exceptions.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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

  @Transactional(readOnly = true)
  public CategoryDTO findById(Long id) {
    Optional<CategoryModel> obj = repository.findById(id);
    CategoryModel entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    return new CategoryDTO(entity);
  }
  @Transactional(readOnly = true)
  public CategoryDTO insert(CategoryDTO dto) {
    CategoryModel entity = new CategoryModel();
    entity.setName(dto.getName());
    entity = repository.save(entity);
    return new CategoryDTO(entity);
  }
}
