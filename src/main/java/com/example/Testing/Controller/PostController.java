package com.example.Testing.Controller;

import com.example.Testing.Service.DTO.PostDto;
import com.example.Testing.Service.DTO.UserDTO;
import com.example.Testing.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PostController {

    private final PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        PostDto returnedPostDTO = postService.createPost(postDto);
        return new ResponseEntity<>(returnedPostDTO, HttpStatus.CREATED);
    }


    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getPosts(){
      return ResponseEntity.ok().body(postService.getPosts());
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost( id);
    }

    @DeleteMapping("/posts")
    public void deleteALlPost(){
        postService.deletePosts();
    }
}
