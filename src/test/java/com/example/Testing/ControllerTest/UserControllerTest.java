package com.example.Testing.ControllerTest;

import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest
public class UserControllerTest {

    @MockBean
    private UserService userService ;

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testSaveUser() throws Exception{
        UserDTO newUserDto = new UserDTO();
        newUserDto.setId(2L);
        newUserDto.setFirstName("abed");
        newUserDto.setLastName("alkrain");
        newUserDto.setEmail("abedalkrain@gmail.com");


        Mockito.when(userService.createUser(ArgumentMatchers.any())).thenReturn(newUserDto);
        String json = mapper.writeValueAsString(newUserDto);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(json)
                .accept(MediaType.APPLICATION_JSON);

       mockMvc.perform(mockRequest)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.firstName", Matchers.equalTo("abed")))
                .andExpect(jsonPath("$.lastName", Matchers.equalTo("alkrain")))
                .andExpect(jsonPath("$.email", Matchers.equalTo("abedalkrain@gmail.com")));


    }

}
