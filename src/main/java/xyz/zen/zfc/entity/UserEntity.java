package xyz.zen.zfc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import xyz.zen.zfc.model.Role;

import java.util.Objects;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "user_zfc")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return enabled == that.enabled
                && Objects.equals(password, that.password)
                && Objects.equals(username, that.username)
                && Objects.equals(email, that.email)
                && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username, email, enabled, role);
    }
}