package com.example.Testing.Service.Mapper;

import com.example.Testing.Domain.Post;
import com.example.Testing.Domain.User;
import com.example.Testing.Service.DTO.PostDto;
import com.example.Testing.Service.DTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostDto, Post>  {
}
