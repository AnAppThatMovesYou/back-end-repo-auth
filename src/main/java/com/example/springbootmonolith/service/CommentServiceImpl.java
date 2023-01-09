package com.example.springbootmonolith.service;


import com.example.springbootmonolith.Exception.ResourceNotFoundException;
import com.example.springbootmonolith.models.Comments;
import com.example.springbootmonolith.models.User;
import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.repositories.BlogRepository;
import com.example.springbootmonolith.repositories.UserRepository;
import com.example.springbootmonolith.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Comments> listComments(){
        return (List<Comments>) commentRepository.findAll();
    }

    @Override
    public Comments getComment(Long id){
        return commentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("comment","id",id));
    }

    @Override
    public Comments createComment(String username, Comments comment){
        User user = userRepository.findByUsername(username);
        comment.setUser(user);
        return commentRepository.save(comment);
    }
}

