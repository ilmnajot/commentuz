package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    SubCategoryDto add(SubCategoryDto dto);

    SubCategoryDto update(Long id,SubCategoryDto dto);

    void delete(Long id);

    List<SubCategoryDto> getAllSub(Long CategoryId);

}
