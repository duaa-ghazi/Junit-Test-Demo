package com.example.Testing.Service;
import com.example.Testing.errors.*;
import com.example.Testing.Domain.User;
import com.example.Testing.Repository.UserRepository;
import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.Mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository ;
    private final UserMapper userMapper ;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser (UserDTO userDTO){
        if(userDTO.getEmail()==null||userDTO.getEmail().equals(""))
            throw new BadRequestAlertException("invalid input ,check email","email attribute","check email input");

        User savedUser= userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(savedUser);
    }
}
