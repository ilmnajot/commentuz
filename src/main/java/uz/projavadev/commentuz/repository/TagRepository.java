package uz.projavadev.commentuz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.projavadev.commentuz.entity.Tag;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Page<Tag> findByNameContains(String searchTerm, Pageable pageable);

    Optional<Tag> findById(Long id);
}
