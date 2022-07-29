package com.example.springbootmonolith.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
@Entity
@Table(name = "blogs")
public class Blogs {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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

    public Blogs(){

    }

//    public Blogs(String title, String summary, String content, String category, String imageUrl, User user) {
//        this.title = title;
//        this.summary = summary;
//        this.content = content;
//        this.category = category;
//        this.imageUrl = imageUrl;
//        this.user = user;
//    }
}
