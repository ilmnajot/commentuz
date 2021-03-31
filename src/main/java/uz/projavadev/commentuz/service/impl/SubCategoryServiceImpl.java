package uz.projavadev.commentuz.service.impl;

import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.SubCategoryDto;
import uz.projavadev.commentuz.entity.SubCategory;
import uz.projavadev.commentuz.repository.CategoryRepository;
import uz.projavadev.commentuz.repository.SubCategoryRepository;
import uz.projavadev.commentuz.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public SubCategoryDto add(SubCategoryDto dto) {
        SubCategory subCategory = new SubCategory();
        subCategory.setCategory(categoryRepository.getOne(dto.getCategoryId()));
        subCategory.setName(dto.getName());
        return SubCategoryDto.toDto(subCategoryRepository.save(subCategory));
    }

    @Override
    public SubCategoryDto update(Long id, SubCategoryDto dto) {
        SubCategory subCategory = subCategoryRepository.getOne(id);
        subCategory.setCategory(categoryRepository.getOne(dto.getCategoryId()));
        subCategory.setName(dto.getName());
        return SubCategoryDto.toDto(subCategoryRepository.save(subCategory));
    }

    @Override
    public void delete(Long id) {
        subCategoryRepository.deleteById(id);
    }
}
