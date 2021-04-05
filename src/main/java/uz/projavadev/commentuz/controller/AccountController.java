package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.projavadev.commentuz.dto.UserDto;
import uz.projavadev.commentuz.entity.User;
import uz.projavadev.commentuz.repository.UserRepository;
import uz.projavadev.commentuz.service.impl.UserServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    private final UserRepository repository;
    private final UserServiceImpl service;

    public AccountController(UserRepository repository, UserServiceImpl service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("account")
    public ResponseEntity getAccount() {
        String login = service.currentUser().get().getUsername();
        Optional<User> user = repository.findByUsername(login);
        return ResponseEntity.ok(UserDto.toDto(user.get()));
    }
}

