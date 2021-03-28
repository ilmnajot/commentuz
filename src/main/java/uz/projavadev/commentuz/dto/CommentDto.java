package uz.projavadev.commentuz.dto;

import lombok.Data;
import uz.projavadev.commentuz.entity.Comment;

@Data
public class CommentDto {

    private Long Id;

    private String content;

    private Long time;

    private String author;

    public static CommentDto toDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setTime(comment.getCreatedDate().getTime());
        dto.setContent(comment.getContent());
        dto.setAuthor(comment.getCreatedBy());
        return dto;
    }
}
