package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Blogs;
import org.springframework.stereotype.Service;

public interface BlogService {

    public Blogs createBlog(Blogs blogs);

    public Iterable<Blogs> listBlogs();
}
