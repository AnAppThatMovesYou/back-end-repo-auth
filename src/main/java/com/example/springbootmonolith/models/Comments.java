package com.example.springbootmonolith.models;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name="comment_blog_id", nullable = false)
    private Blogs blogs;

    public void setBlogs(Blogs blogs){this.blogs = blogs;}

    public Blogs getBlogs(){return blogs;}

    public Long getBlogsCommentId() {return blogs.getId();}

    public Comments(){

    }

    @ManyToOne
    @JoinColumn(name = "comment_user_id", nullable = false)
    private User user;

    public void setUser(User user){ this.user = user; }

    public User getUser(){ return user; }

    public Long getUserCommentId(){
        return user.getId();
    }

}


