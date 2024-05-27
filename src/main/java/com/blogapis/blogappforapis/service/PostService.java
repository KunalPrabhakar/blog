package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.payload.postDTO;

import java.util.List;

public interface PostService {
    postDTO createPost(postDTO postdto, Long catId, Long userId);

    Post updatePost(Post post, Long postId);
void deletePost(Long postId);
List<Post>getAllPost();
Post getPostById(Long postId);
List<Post>getAllPostByCategory(Long catId);
List<Post>getAllPostByUser(Long userId);
List<Post>searchPosts(String keyword);
}
