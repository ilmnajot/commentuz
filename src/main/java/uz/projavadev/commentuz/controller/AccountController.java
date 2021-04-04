package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.projavadev.commentuz.entity.User;
import uz.projavadev.commentuz.exception.UserNotFoundException;
import uz.projavadev.commentuz.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    private final UserRepository repository;

    public AccountController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("account")
    public ResponseEntity getAccount() {
        String login = currentUser().get().getUsername();
        Optional<User> user = repository.findByUsername(login);
        return ResponseEntity.ok(user);
    }


    public Optional<User> currentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String username = securityContext.getAuthentication().getName();
        Optional<User> currentUser = repository.findByUsername(username);
        if (!currentUser.isPresent()) throw new UserNotFoundException("Problem with token, please re-sign in");
        return currentUser;
    }
}
