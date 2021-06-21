package uz.projavadev.commentuz.entity;

import org.springframework.stereotype.Component;
import uz.projavadev.commentuz.dto.UserRole;
import uz.projavadev.commentuz.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    private final UserRepository userRepository;

    public DbInit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    private void postConstruct() {
        if (!userRepository.existsByRole(UserRole.DEVELOPER)) {
            User developer = new User(
                    "Javohir",
                    "temjashu",
                    "$2y$12$2jbXGdrQLMFX3mJ80SNXoe4XoVv6IzyB.EQUlDJjxyEW2OdKsaK2C",
                    "temjashu8464@gmail.com",
                    "+998911338464",
                    UserRole.DEVELOPER,
                    true
            );
            userRepository.save(developer);
        }
    }
}