package uz.projavadev.commentuz.dto;

import com.sun.istack.NotNull;
import lombok.Data;


@Data
public class CommentForm {

    @NotNull
    private Long postId;

    private String content;
}
