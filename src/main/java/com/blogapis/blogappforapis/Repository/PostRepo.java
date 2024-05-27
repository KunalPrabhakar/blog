package com.blogapis.blogappforapis.Repository;

import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUser(User user);
    List<Post> findByCategories(Categories categories);
}
