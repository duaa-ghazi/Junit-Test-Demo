package com.example.Testing.Service;

import com.example.Testing.Domain.Post;
import com.example.Testing.Domain.User;
import com.example.Testing.Repository.PostRepository;
import com.example.Testing.Service.DTO.PostDto;
import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.Mapper.PostMapper;
import com.example.Testing.errors.BadRequestAlertException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository ;
    private final PostMapper postMapper ;


    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDto createPost (PostDto postDto){

        Post savedPost= postRepository.save(postMapper.toEntity(postDto));
        return postMapper.toDto(savedPost);
    }

    public List<PostDto> getPosts (){
        return postMapper.toDto(postRepository.findAll());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public void deletePosts() {
        postRepository.deleteAll();
    }
}
