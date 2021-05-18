package uz.projavadev.commentuz.dto;

import lombok.Data;
import uz.projavadev.commentuz.entity.Tag;

@Data
public class TagDto {

    private Long id;

    private String name;

    public static TagDto toDto(Tag tag) {
        TagDto dto = new TagDto();
        dto.setId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }

}
