package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.projavadev.commentuz.dto.VoteType;
import uz.projavadev.commentuz.entity.Post;
import uz.projavadev.commentuz.entity.PostVote;

import java.util.Optional;

@Repository
public interface PostVoteRepository extends JpaRepository<PostVote, Long> {

    Optional<PostVote> findByPostIdAndCreatedBy(Long postId, String username);

    long countByPostAndType(Post post, VoteType type);
}
