package uz.projavadev.commentuz.dto;

import lombok.Data;
import uz.projavadev.commentuz.entity.PostVote;

@Data
public class PostVoteDto {

    private Long id;

    private Long postId;

    private VoteType type;

    public static PostVoteDto toDto(PostVote vote) {
        PostVoteDto dto = new PostVoteDto();
        dto.setId(vote.getId());
        dto.setPostId(vote.getPost().getId());
        dto.setType(vote.getType());
        return dto;
    }
}
