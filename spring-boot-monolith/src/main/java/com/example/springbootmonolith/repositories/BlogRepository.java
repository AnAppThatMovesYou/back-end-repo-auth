package com.example.springbootmonolith.repositories;

import com.example.springbootmonolith.models.Blogs;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blogs, Long> {
}
