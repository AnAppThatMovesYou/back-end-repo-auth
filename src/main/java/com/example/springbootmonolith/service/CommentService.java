package com.example.springbootmonolith.service;

import com.example.springbootmonolith.models.Comments;
import java.util.List;

public interface CommentService {
    public Comments createComment(String username, Comments comments);
    public List<Comments> listComments();
    public Comments getComment(Long id);
}
