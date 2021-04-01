package uz.projavadev.commentuz.service;

import uz.projavadev.commentuz.dto.UserDto;

public interface UserService {

    UserDto create(UserDto dto);

    Boolean existsUsername(String username);

    Boolean checkPasswordLength(String password);
}
