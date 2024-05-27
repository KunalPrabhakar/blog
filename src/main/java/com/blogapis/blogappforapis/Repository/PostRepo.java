package com.blogapis.blogappforapis.Repository;

import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
//List<Post> getAllPostOfUser(Post post);
//List<Post>getAllPostByCategory(Categories categories);

}
