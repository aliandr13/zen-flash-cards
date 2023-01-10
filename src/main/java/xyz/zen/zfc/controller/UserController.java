package xyz.zen.zfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.zen.zfc.dto.Message;
import xyz.zen.zfc.dto.SignUpDto;
import xyz.zen.zfc.model.User;
import xyz.zen.zfc.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage(final Model model) {
        model.addAttribute("signupDto", new SignUpDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(final Model model, @ModelAttribute final SignUpDto signUpDto) {
        System.out.println(signUpDto);

        User user = userService.createUser(signUpDto);

        String message = String.format("User '%s' registered successfully", user.getUsername());
        model.addAttribute("message", new Message("Sign up", message));
        return "message";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }


}
