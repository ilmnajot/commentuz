package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.projavadev.commentuz.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
