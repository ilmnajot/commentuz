package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto add(CategoryDto dto);

    CategoryDto update(Long id, CategoryDto dto);

    void delete(Long id);

    List<CategoryDto> getAllCategory();
}
