package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.Repository.CategoryRepo;
import com.blogapis.blogappforapis.Repository.PostRepo;
import com.blogapis.blogappforapis.Repository.UserRepo;
import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.entities.User;
import com.blogapis.blogappforapis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
   @Autowired
    private PostRepo postRepo;

   @Autowired
   private UserRepo userRepo;

   @Autowired
   private CategoryRepo categoryRepo;
    @Override
    public Post createPost(Post post, Long catId, Long userId) {
   User user=userRepo.findById(userId).orElse(null);
   Categories category= categoryRepo.findById(catId).orElse(null);
    post.setDateofpost(new Date());
    post.setUser(user);
    post.setCategories(category);

    return postRepo.save(post);
    }

    @Override
    public Post updatePost(Post post, Long postId) {
       Post posttobeupdated=postRepo.findById(postId).orElse(null);
       posttobeupdated.setCategories(post.getCategories());
       posttobeupdated.setContent(post.getContent());
       posttobeupdated.setTitle(post.getTitle());
       posttobeupdated.setImage(post.getImage());
       posttobeupdated.setUser(post.getUser());
       posttobeupdated.setDateofpost(post.getDateofpost());
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getAllPostByCategory(Long catId) {
        return List.of();
    }

    @Override
    public List<Post> getAllPostByUser(Long userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
