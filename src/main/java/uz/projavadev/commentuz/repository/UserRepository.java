package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.projavadev.commentuz.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
