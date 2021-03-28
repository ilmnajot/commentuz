package uz.projavadev.commentuz.dto;

import lombok.Data;
import uz.projavadev.commentuz.entity.Comment;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.PostVote;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDto extends PostListItemDto {

    private PostVoteDto vote;

    private List<CommentDto> comment;

    public static class Builder {

        private Post post;

        private List<Comment> comments;

        private PostVote vote;

        public Builder(Post post) {
            this.post = post;
        }

        public Builder vote(PostVote vote) {
            this.vote = vote;
            return this;
        }

        public Builder comments(List<Comment> comments) {
            this.comments = comments;
            return this;
        }

        public PostDto build() {
            PostDto dto = new PostDto();
            dto.setId(post.getId());
            dto.setName(post.getName());
            dto.setImage(post.getImage());
            dto.setTags(post.getTags().stream().map(TagDto::toDto).collect(Collectors.toSet()));
            dto.setVoteCount(post.getVoteCount());
            dto.setViewCount(post.getViewCount());
            dto.setTime(post.getCreatedDate().getTime());
            dto.setAuthor(post.getCreatedBy());
            if (this.vote != null) {
                dto.setVote(PostVoteDto.toDto(this.vote));
            }
            if (this.comments != null) {
                dto.setComment(this.comments.stream().map(CommentDto::toDto).collect(Collectors.toList()));
            }
            return dto;
        }
    }
}
