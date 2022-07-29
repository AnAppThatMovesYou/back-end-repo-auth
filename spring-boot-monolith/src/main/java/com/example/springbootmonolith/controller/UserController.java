package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.config.JwtUtil;
import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.JwtResponse;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.service.BlogService;
import com.example.springbootmonolith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/user/list")
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
    }

    //    @PutMapping("/user/{username}/{blogId}")
//    public User addBlog(@PathVariable String username, @PathVariable Long blogId){
//        return userService.addBlog(username, blogId);
//    }
    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        return userService.deleteById(userId);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }

//    @PostMapping("/blogs")
//    public Blogs createBlog(Blogs newBlog){
//        String username = newBlog.getUser().getUsername();
//        return blogService.createBlog(username, newBlog);
//    }
}



