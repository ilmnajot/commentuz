package uz.projavadev.commentuz.entity;

import lombok.Data;
import uz.projavadev.commentuz.dto.UserRole;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "users")
@Data
public class User extends BaseEntity {

    private String name;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    private String phoneNumber;


}
