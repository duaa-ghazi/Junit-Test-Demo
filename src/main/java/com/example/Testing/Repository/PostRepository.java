package com.example.Testing.Repository;

import com.example.Testing.Domain.Post;
import com.example.Testing.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
