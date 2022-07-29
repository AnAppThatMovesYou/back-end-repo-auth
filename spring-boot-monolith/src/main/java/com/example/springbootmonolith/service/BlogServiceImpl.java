package com.example.springbootmonolith.service;

import com.example.springbootmonolith.Exception.ResourceNotFoundException;
import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.models.UserRole;
import com.example.springbootmonolith.repositories.BlogRepository;
import com.example.springbootmonolith.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;
//
//    @Override
//    public String createUser(User newUser) {
//        UserRole userRole = userRoleService.getRole("ROLE_User");
//        newUser.setUserRole(userRole);
//        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
//        if (userRepository.save(newUser) != null) {
//
//            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
//            return jwtUtil.generateToken(userDetails);
//        }
//        return null;
//    }


//    @Override
//    public Blogs createBlog(Blogs blog) {
//        User user = userService.getUserById(blog.getUserBlogId());
//        user.setUserBlogs(blog);
//        return blogRepository.save(blog);
//    }

    @Override
    public List<Blogs> listBlogs() {
        return (List<Blogs>) blogRepository.findAll();
    }

    @Override
    public Blogs getBlog(Long id) {
        return blogRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("blog","id",id));
    }

    @Override
    public Blogs createBlog(String username, Blogs blog) {
        System.out.println(blog.getTitle());
        User user = userRepository.findByUsername(username);
        blog.setUser(user);
        return blogRepository.save(blog);
    }

}
