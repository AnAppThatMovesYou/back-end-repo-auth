package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    @Autowired
    BlogService blogService;

    @PostMapping
    public Iterable<Blogs> createBlog(@RequestBody Blogs blogs){
        blogService.createBlog(blogs);
        return blogService.listBlogs();
    }

    @GetMapping("/list")
    public Iterable<Blogs> listBlogs(){
        return blogService.listBlogs();
    }

}
