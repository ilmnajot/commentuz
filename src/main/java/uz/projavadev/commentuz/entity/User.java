package uz.projavadev.commentuz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import uz.projavadev.commentuz.dto.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@Entity(name = "users")
@Data
public class User extends BaseEntity {

    private String name;

    private String username;

    private String password;

    private String email;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean confirmed = false;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    private String phoneNumber;


    public User(String name, String username, String password, String email, String phoneNumber) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
