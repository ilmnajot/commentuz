package uz.projavadev.commentuz.service.impl;

import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.CategoryDto;
import uz.projavadev.commentuz.entity.Category;
import uz.projavadev.commentuz.repository.CategoryRepository;
import uz.projavadev.commentuz.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryDto add(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return CategoryDto.toDto(repository.save(category));
    }
}
