package uz.projavadev.commentuz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.projavadev.commentuz.entity.User;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DevAddUserDto {

    private String name;

    private String username;

    private String password;

    private String email;

    private UserRole role;

    private String phoneNumber;

    public static DevAddUserDto toDto(User user) {
        DevAddUserDto dto = new DevAddUserDto();
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }
}
