package uz.projavadev.commentuz.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Data
public class PostForm {

    @NotNull
    private Long subcategoryIid;

    private MultipartFile image;

    private String name;

    private Set<TagDto> tags;

}
