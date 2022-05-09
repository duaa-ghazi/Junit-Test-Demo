package com.example.Testing.ServiceTest;
import com.example.Testing.errors.*;
import com.example.Testing.Domain.User;
import com.example.Testing.Repository.UserRepository;
import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.Mapper.UserMapper;
import com.example.Testing.Service.UserService;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.internal.matchers.NotNull;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Value("${server.port}")
    private int serverPort;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;


    @Test
    @DisplayName("Should create User")
    public void testCreateUserCase1() throws Exception {
        UserDTO givenDto = new UserDTO();
        givenDto.setId(2L);
        givenDto.setFirstName("abed");
        givenDto.setLastName("alkrain");
        givenDto.setEmail("abedalkrain@gmail.com");

        User savedUser = new User();
        savedUser.setId(2L);
        savedUser.setFirstName("abed");
        savedUser.setLastName("alkrain");
        savedUser.setEmail("abedalkrain@gmail.com");


        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(savedUser);
        Mockito.when(userMapper.toEntity(Mockito.any(UserDTO.class))).thenReturn(savedUser);
        Mockito.when(userMapper.toDto(Mockito.any(User.class))).thenReturn(givenDto);


        userService.createUser(givenDto);
        Mockito.verify(userRepository, Mockito.times(1)).save(userArgumentCaptor.capture());
        Assertions.assertThat(userArgumentCaptor.getValue().getFirstName()).isEqualTo("abed");
        Assertions.assertThat(userArgumentCaptor.getValue().getLastName()).isEqualTo("alkrain");
        Assertions.assertThat(userArgumentCaptor.getValue().getEmail()).isEqualTo("abedalkrain@gmail.com");
        //this assert is the same of above
        //assertEquals("abed", userArgumentCaptor.getValue().getFirstName());

    }

    @Test()
    @DisplayName("Should throw exception with empty email")
    public void testCreateUserCase2() throws Exception {
        UserDTO givenDto = new UserDTO();
        givenDto.setId(2L);
        givenDto.setFirstName("abed");
        givenDto.setLastName("alkrain");
//        givenDto.setEmail("abedalkrain@gmail.com");

        BadRequestAlertException exception = assertThrows(BadRequestAlertException.class, () -> {
            userService.createUser(givenDto);
        });
        String expectedMessage = "invalid input ,check email";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

//    @Test()
//    @DisplayName("")
//    public void testCreateUserCase3() throws Exception {
//
//    }

}