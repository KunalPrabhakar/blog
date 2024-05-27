package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.payload.postDTO;

import java.util.List;

public interface PostService {
    postDTO createPost(postDTO postdto, Long catId, Long userId);

    Post updatePost(Post post, Long postId);
void deletePost(Long postId);
List<postDTO>getAllPost(Integer pageNumber,Integer pageSize);
Post getPostById(Long postId);
List<postDTO>getAllPostByCategory(Long catId);
List<postDTO>getAllPostByUser(Long userId);
List<postDTO>searchPosts(String keyword);
}
