package uz.projavadev.commentuz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.projavadev.commentuz.dto.UserDto;
import uz.projavadev.commentuz.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("register")
    public ResponseEntity create(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }


}
