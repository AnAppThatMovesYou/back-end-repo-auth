package com.example.springbootmonolith.controller;

import com.example.springbootmonolith.models.Comments;
import com.example.springbootmonolith.models.Blogs;
import com.example.springbootmonolith.models.UserProfile;
import com.example.springbootmonolith.repositories.BlogRepository;
import com.example.springbootmonolith.service.BlogService;
import com.example.springbootmonolith.repositories.CommentRepository;
import com.example.springbootmonolith.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    CommentService commentService;

    @Autowired
    public CommentRepository commentRepository;

    @CrossOrigin
    @GetMapping
    public  List<Comments> getAllComments(){
        return commentService.listComments();
    }

    @CrossOrigin
    @GetMapping("/{commentId}")
    public Comments getComment(@PathVariable Long commentId){
        return commentService.getComment(commentId);
    }

    @CrossOrigin
    @PostMapping("/{username}")
    public Comments createComment(@PathVariable String username, @RequestBody Comments comment){
        return commentService.createComment(username, comment);
    }

    @CrossOrigin
    @PutMapping("/{commentId}")
    public Comments updateComment(@PathVariable Long commentId, @RequestBody Comments newComment){
        //find comment with given id
        Comments existingComment = commentService.getComment(commentId);

        //update comment
        existingComment.setTitle(newComment.getTitle());
        existingComment.setContent(newComment.getContent());

        //save updated comment
        commentRepository.save(existingComment);

        //return updated comment
        return existingComment;
    }

    @CrossOrigin
    @DeleteMapping("/{commentId}")
    public HttpStatus deleteBlog(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return HttpStatus.OK;
    }
}
