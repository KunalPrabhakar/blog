package com.blogapis.blogappforapis.Repository;

import com.blogapis.blogappforapis.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
