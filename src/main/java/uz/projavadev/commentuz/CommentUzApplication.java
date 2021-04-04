package uz.projavadev.commentuz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CommentUzApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommentUzApplication.class, args);
    }
}
