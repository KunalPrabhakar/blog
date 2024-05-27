package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.entities.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post, Long catId, Long userId);

    Post updatePost(Post post, Long postId);
void deletePost(Long postId);
List<Post>getAllPost();
Post getPostById(Long postId);
List<Post>getAllPostByCategory(Long catId);
List<Post>getAllPostByUser(Long userId);
List<Post>searchPosts(String keyword);
}
