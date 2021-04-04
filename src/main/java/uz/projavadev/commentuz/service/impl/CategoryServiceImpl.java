package uz.projavadev.commentuz.service.impl;

import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.CategoryDto;
import uz.projavadev.commentuz.entity.Category;
import uz.projavadev.commentuz.repository.CategoryRepository;
import uz.projavadev.commentuz.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CategoryDto update(Long id, CategoryDto dto) {
        Category category = repository.getOne(id);
        category.setName(dto.getName());
        return CategoryDto.toDto(repository.save(category));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return repository.findAll().stream().map(CategoryDto::toDto).collect(Collectors.toList());
    }
}
