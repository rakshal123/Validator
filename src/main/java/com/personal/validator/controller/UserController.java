package com.personal.validator.controller;

import com.personal.validator.dto.UserDTO;
import com.personal.validator.dto.UserResponseDTO;
import com.personal.validator.entity.User;
import com.personal.validator.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("users")
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserResponseDTO> response = users.stream()
                .map(user -> UserResponseDTO.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .build())
                .toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/insert-user")
    public ResponseEntity<UserResponseDTO> insertUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPhoneNumber(userDTO.phoneNumber());
        this.userRepository.save(user);
        return new ResponseEntity<>(UserResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build(), HttpStatusCode.valueOf(204));
    }
}
