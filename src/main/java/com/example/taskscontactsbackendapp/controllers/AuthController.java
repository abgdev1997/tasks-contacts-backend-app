package com.example.taskscontactsbackendapp.controllers;

import com.example.taskscontactsbackendapp.dto.LoginDTO;
import com.example.taskscontactsbackendapp.dto.MessageDTO;
import com.example.taskscontactsbackendapp.dto.RegisterDTO;
import com.example.taskscontactsbackendapp.models.User;
import com.example.taskscontactsbackendapp.repository.UserRepository;
import com.example.taskscontactsbackendapp.security.jwt.JwtTokenUtil;
import com.example.taskscontactsbackendapp.security.payload.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginDTO loginRequest){

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> register(@RequestBody RegisterDTO signUpRequest) {

        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageDTO("ERROR: The username exists"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageDTO("ERROR: The email exists"));
        }

        User user;
        user = new User();
        user.setId(null);
        user.setUsername((String) signUpRequest.getUsername());
        user.setEmail((String) signUpRequest.getEmail());
        user.setPassword((String) encoder.encode(signUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageDTO("User registered successfully"));
    }

}
