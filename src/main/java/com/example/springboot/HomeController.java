package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public HomeController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String home(Model model) {
        model.addAttribute("message", "Hello, this is a dynamic message!");
        return "index";
    }
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signupcheck")
    public ResponseEntity<String> signUp(@RequestBody People user){
        userRepository.save(user);
        return ResponseEntity.ok("People signed up successfully!");
    }

}