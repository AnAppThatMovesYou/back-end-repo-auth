package com.example.springbootmonolith.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blogs")
public class Blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column
    private String content;

    @Column
    private String category;

    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_blog_id", nullable = false)
    private User user;


    public void setUser(User user){ this.user = user; }

    public User getUser(){ return user; }

    public Long getUserBlogId(){
        return user.getId();
    }

    public Blogs(String title, String summary, String content, String category, String imageUrl, User user) {
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.imageUrl = imageUrl;
        this.user = user;
    }
}
