package com.jihun.simpleGame.controller;

import com.jihun.simpleGame.auth.JwtUtil;
import com.jihun.simpleGame.dto.UserResponse;
import com.jihun.simpleGame.entity.member.Member;
import com.jihun.simpleGame.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody Member user) {
        Member savedUser = authService.saveUser(user);
        return ResponseEntity.ok(UserResponse.fromEntity(savedUser));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> createAuthenticationToken(@RequestBody Member user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            final String jwt = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(jwt);
        } else {
            return ResponseEntity.badRequest().body("Authentication failed");
        }
    }

    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUserInfo(@RequestParam String username) {
        UserResponse userResponse = authService.findByUsername(username);
        return ResponseEntity.ok(userResponse);
    }
}