package uz.projavadev.commentuz.dto;

import lombok.Data;
import uz.projavadev.commentuz.entity.SubCategory;

@Data
public class SubCategoryDto {

    private Long id;

    private Long categoryId;

    private String name;

    public static SubCategoryDto toDto(SubCategory subCategory) {
        SubCategoryDto dto = new SubCategoryDto();
        dto.setId(subCategory.getId());
        dto.setCategoryId(subCategory.getCategory().getId());
        dto.setName(subCategory.getName());
        return dto;
    }
}
