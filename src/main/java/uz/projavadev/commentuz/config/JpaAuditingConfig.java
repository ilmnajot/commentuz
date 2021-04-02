package uz.projavadev.commentuz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.projavadev.commentuz.repository.UserRepository;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    private final UserRepository userRepository;

    public JpaAuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<String> userAuditorAware() {
        return () -> {
            SecurityContext context = SecurityContextHolder.getContext();
            if (context != null && context.getAuthentication() != null) {
                return Optional.ofNullable(context.getAuthentication().getName());
            }
            return Optional.empty();
        };
    }

}
