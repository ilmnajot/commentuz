package uz.projavadev.commentuz.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class PostForm {

    @NotNull
    private Long subcategoryIid;

    private String name;

    private Set<TagDto> tags;

}
