package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.JwtResponse;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.repositories.UserRepository;
import com.example.springbootmonolith.service.BlogService;
import com.example.springbootmonolith.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BlogService blogService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok(new JwtResponse(userService.login(user)));
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @CrossOrigin
    @GetMapping("/user/list")
    public Iterable<User> listUsers() {
        return userService.listUsers();
    }


    @CrossOrigin
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }


    @CrossOrigin
    @PostMapping("/signup")
//    public ResponseEntity<?> createUser(@RequestBody User newUser) {
//        return ResponseEntity.ok(new JwtResponse(userService.createUser(newUser)));
//    }
    public ResponseEntity<?> signUp(@RequestBody User user) throws Exception {
        Optional<User> usernameEntry = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (usernameEntry.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }else { // filter as you need in this method
//            userRepository.save(user);
//            System.out.println("New user submission!");
            return ResponseEntity.ok(new JwtResponse(userService.createUser(user)));
        }
    }



    //    @PutMapping("/user/{username}/{blogId}")
//    public User addBlog(@PathVariable String username, @PathVariable Long blogId){
//        return userService.addBlog(username, blogId);
//    }
    @CrossOrigin
    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        return userService.deleteById(userId);
    }

    @CrossOrigin
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



