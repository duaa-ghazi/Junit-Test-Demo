package com.example.Testing.Controller;

import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService ;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO returnedUserDTO = userService.createUser(userDTO);
        return new ResponseEntity<>(returnedUserDTO, HttpStatus.CREATED);
    }
}
