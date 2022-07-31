package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.UserProfile;
import com.example.springbootmonolith.repositories.BlogRepository;
import com.example.springbootmonolith.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {

    @Autowired
    BlogService blogService;

    @Autowired
    public BlogRepository blogRepository;

    @CrossOrigin
    @GetMapping
    public List<Blogs> getAllBlogs() {
        return blogService.listBlogs();
    }


    @CrossOrigin
    @GetMapping("/{blogId}")
    public Blogs getBlog(@PathVariable Long blogId) {
        return blogService.getBlog(blogId);
    }

    @CrossOrigin
    @PostMapping("/{username}")
    public Blogs createBlog(@PathVariable String username, @RequestBody Blogs blog) {
        return blogService.createBlog(username,blog);
    }

    @CrossOrigin
    @PutMapping("/{blogId}")
    public Blogs updateBlog(@PathVariable Long blogId, @RequestBody Blogs newBlog){
        //find blog with id
        Blogs existingBlog = blogService.getBlog(blogId);

        //update blog
        existingBlog.setTitle(newBlog.getTitle());
        existingBlog.setSummary(newBlog.getSummary());
        existingBlog.setContent(newBlog.getContent());
        existingBlog.setCategory(newBlog.getCategory());
        existingBlog.setImageUrl(newBlog.getImageUrl());

        //save updated blog
        blogRepository.save(existingBlog);

        //return updated blog
        return existingBlog;
    }

    @CrossOrigin
    @DeleteMapping("/{blogId}")
    public HttpStatus deleteBlog(@PathVariable Long blogId){
        blogRepository.deleteById(blogId);
        return HttpStatus.OK;
    }
}