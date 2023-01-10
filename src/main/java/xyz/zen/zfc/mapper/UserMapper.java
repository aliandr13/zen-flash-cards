package xyz.zen.zfc.mapper;

import org.springframework.stereotype.Component;
import xyz.zen.zfc.entity.UserEntity;
import xyz.zen.zfc.model.User;

@Component
public class UserMapper {

    public User map(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .enabled(entity.isEnabled())
                .role(entity.getRole())
                .build();
    }

    public UserEntity map(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .role(user.getRole())
                .build();
    }

}
