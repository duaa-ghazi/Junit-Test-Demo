package com.example.Testing.Domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;


@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;

    @NonNull
    @Column(name = "title")
    private String title ;

    @NonNull
    @Column(name = "content")
    private String content;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }
}
