package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.projavadev.commentuz.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}
