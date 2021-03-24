package uz.projavadev.commentuz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.projavadev.commentuz.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
