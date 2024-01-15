package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public HomeController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
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

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @PostMapping("/signupcheck")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody People user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body("{\"message\": \"People signed up successfully!\"}");
    }

    @PostMapping("/logincheck")
    @ResponseBody
    public ResponseEntity<String> loginCheck(@RequestBody People user) {
        People existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (existingUser != null) {
            // User authenticated successfully
            return ResponseEntity.ok("{\"message\": \"Login successful!\"}");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .header("Content-Type", "application/json")
                    .body("{\"message\": \"Invalid email or password\"}");
        }
    }


}