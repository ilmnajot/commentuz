package uz.projavadev.commentuz.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PostListItemDto {

    private Long id;

    private String name;

    private String image;

    private Set<TagDto> tags;

    private Long viewCount;

    private Long voteCount;

    private Long time;

    private String author;

}
