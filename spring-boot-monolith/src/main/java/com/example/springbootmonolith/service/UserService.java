package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.models.UserProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User getUser(String username);

    public User getUserById(long id);


    public Iterable<User> listUsers();

    public String createUser(User newUser);

    public String login(User user);

    User addBlog(String username, Long blogId);

    public HttpStatus deleteById(Long userId);

}