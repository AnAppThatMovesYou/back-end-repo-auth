package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Blogs;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {

    public Blogs createBlog(String username, Blogs blogs);

    public List<Blogs> listBlogs();

    public Blogs getBlog(Long id);

}
