package xyz.zen.zfc.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

public enum Role {
    ADMIN, USER;

    @Getter
    private final GrantedAuthority authority;

    Role() {
        this.authority = new SimpleGrantedAuthority(name());
    }

    public static Role getByName(GrantedAuthority authority) {
        return Arrays.stream(Role.values())
                .filter(r -> r.authority.equals(authority))
                .findAny().orElseThrow();
    }

}
