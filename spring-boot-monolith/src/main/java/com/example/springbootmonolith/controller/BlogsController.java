package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.UserProfile;
import com.example.springbootmonolith.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    @Autowired
    BlogService blogService;

    @GetMapping
    public List<Blogs> getAllBlogs() {
        return blogService.listBlogs();
    }


    @GetMapping("/{blogId}")
    public Blogs getBlog(@PathVariable Long blogId) {
        return blogService.getBlog(blogId);
    }

    @PostMapping("/{username}")
    public Blogs createBlog(@PathVariable String username, @RequestBody Blogs blog) {
        return blogService.createBlog(username,blog);
    }
}