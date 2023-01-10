package xyz.zen.zfc.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import xyz.zen.zfc.model.User;

import java.security.Principal;
import java.util.UUID;

public class BaseController {

    protected UUID getUserId(Principal principal) {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) principal;
        User user = (User) token.getPrincipal();
        return user.getId();
    }

}
