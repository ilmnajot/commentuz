package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.projavadev.commentuz.entity.PostVote;

public interface PostVoteRepository extends JpaRepository<PostVote, Long> {

}
