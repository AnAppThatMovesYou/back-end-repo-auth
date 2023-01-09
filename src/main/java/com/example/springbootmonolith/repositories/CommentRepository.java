package com.example.springbootmonolith.repositories;

import com.example.springbootmonolith.models.Comments;
import org.springframework.data.repository.CrudRepository;
public interface CommentRepository extends CrudRepository<Comments, Long> {
}
