package com.example.Testing.Service.Mapper;
import com.example.Testing.Domain.User;
import com.example.Testing.Service.DTO.UserDTO;
import org.mapstruct.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
