package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.projavadev.commentuz.dto.VoteType;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.PostVote;

import java.util.Optional;

public interface PostVoteRepository extends JpaRepository<PostVote, Long> {

    Optional<PostVote> findByPostId(Long postId, String username);

    long countByPost(Post post, VoteType type);
}
