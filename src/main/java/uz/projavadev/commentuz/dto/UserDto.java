package uz.projavadev.commentuz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import uz.projavadev.commentuz.entity.User;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDto {

    private Long id;

    private String name;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }

}
