package xyz.zen.zfc.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zen.zfc.entity.UserEntity;
import xyz.zen.zfc.repository.UserRepository;

import java.util.Collection;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userService;

    public UserApiController(UserRepository userService) {
        this.userService = userService;
    }

//    @GetMapping(path = "/{email}")
//    public UserDetails getUserByEmail(@PathVariable String email) {
//        return userService.loadUserByUsername(email);
//    }

    @GetMapping
    public Collection<UserEntity> getUserAll() {
        return userService.findAll();
    }

}
