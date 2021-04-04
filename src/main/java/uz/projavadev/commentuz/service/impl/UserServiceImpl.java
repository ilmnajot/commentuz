package uz.projavadev.commentuz.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.projavadev.commentuz.dto.DevAddUserDto;
import uz.projavadev.commentuz.dto.UserDto;
import uz.projavadev.commentuz.dto.UserRole;
import uz.projavadev.commentuz.entity.User;
import uz.projavadev.commentuz.exception.UserNotFoundException;
import uz.projavadev.commentuz.repository.UserRepository;
import uz.projavadev.commentuz.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(UserDto dto) {
        if (!checkPasswordLength(dto.getPassword()))
            throw new UserNotFoundException("Length of password is lower than 4");
        if (existsUsername(dto.getUsername())) throw new UserNotFoundException("This username is already exists");
        return UserDto.toDto(userRepository.save(
                new User(
                        dto.getName(),
                        dto.getUsername(),
                        passwordEncoder.encode(dto.getPassword()),
                        dto.getEmail(),
                        dto.getPhoneNumber(),
                        UserRole.USER,
                        true
                )
        ));
    }

    @Override
    public Boolean existsUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean checkPasswordLength(String password) {
        return password.length() >= 4;
    }

    @Override
    public DevAddUserDto devCreateAdmin(DevAddUserDto dto) {
        if (!checkPasswordLength(dto.getPassword()))
            throw new UserNotFoundException("Length of password is lower than 4");
        if (existsUsername(dto.getUsername())) throw new UserNotFoundException("This username is already exists");
        return DevAddUserDto.toDto(userRepository.save(
                new User(
                        dto.getName(),
                        dto.getUsername(),
                        passwordEncoder.encode(dto.getPassword()),
                        dto.getEmail(),
                        dto.getPhoneNumber(),
                        dto.getRole(),
                        true
                )
        ));
    }

    @Override
    public DevAddUserDto adminCreateModer(DevAddUserDto dto) {
        if (!checkPasswordLength(dto.getPassword()))
            throw new UserNotFoundException("Length of password is lower than 4");
        if (existsUsername(dto.getUsername())) throw new UserNotFoundException("This username is already exists");
        return DevAddUserDto.toDto(userRepository.save(
                new User(
                        dto.getName(),
                        dto.getUsername(),
                        passwordEncoder.encode(dto.getPassword()),
                        dto.getEmail(),
                        dto.getPhoneNumber(),
                        UserRole.MODERATOR,
                        true
                )
        ));
    }
}
