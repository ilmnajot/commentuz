package uz.projavadev.commentuz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.projavadev.commentuz.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllBySubCategoryId(Long id, Pageable pageable);

    Page<Post> findAllByCreatedBy(String username, Pageable pageable);

}
