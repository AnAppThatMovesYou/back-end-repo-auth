package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.models.UserRole;
import com.example.springbootmonolith.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserService userService;
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


    @Override
    public Blogs createBlog(Blogs blog) {
        User user = userService.getUserById(blog.getUserBlogId());
        user.setUserBlogs(blog);
        return blogRepository.save(blog);
    }

    @Override
    public Iterable<Blogs> listBlogs() {
        return blogRepository.findAll();
    }
}
