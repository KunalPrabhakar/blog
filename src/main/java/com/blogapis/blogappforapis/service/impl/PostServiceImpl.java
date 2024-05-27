package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.Repository.CategoryRepo;
import com.blogapis.blogappforapis.Repository.PostRepo;
import com.blogapis.blogappforapis.Repository.UserRepo;
import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.entities.Post;
import com.blogapis.blogappforapis.entities.User;
import com.blogapis.blogappforapis.payload.postDTO;
import com.blogapis.blogappforapis.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
   @Autowired
    private PostRepo postRepo;

   @Autowired
   private UserRepo userRepo;

   @Autowired
   private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public postDTO createPost(postDTO post, Long catId, Long userId) {
   User user=userRepo.findById(userId).orElse(null);
   Categories category= categoryRepo.findById(catId).orElse(null);
Post posttobesaved= modelMapper.map(post,Post.class);
posttobesaved.setUser(user);
posttobesaved.setCategories(category);
posttobesaved.setDateofpost(new Date());
   return modelMapper.map(postRepo.save(posttobesaved),postDTO.class);
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
    postRepo.deleteById(postId);
    }

    @Override
    public List<postDTO> getAllPost(Integer pageNumber,Integer pageSize) {

        Pageable page= PageRequest.of(pageNumber,pageSize);
      Page<Post> posts = postRepo.findAll(page);
        List<Post> postContent=posts.getContent();

      return  postContent.stream().map((post)->modelMapper.map(post,postDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<postDTO> getAllPostByCategory(Long catId) {
      List<Post> postsByCategory= postRepo.findByCategories(categoryRepo.findById(catId).orElse(null));
        return postsByCategory.stream().map((post)->modelMapper.map(post,postDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<postDTO> getAllPostByUser(Long userId) {
        List <Post>postsofUser= postRepo.findByUser( userRepo.findById(userId).orElse(null));
      return  postsofUser.stream().map((post)->modelMapper.map(post,postDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<postDTO> searchPosts(String keyword) {
      List<Post> posts = postRepo.findAll().stream()
    .filter(post -> (post.getTitle() != null && post.getTitle().contains(keyword)) ||
                    (post.getContent() != null && post.getContent().contains(keyword)))
    .collect(Collectors.toList());

        return posts.stream()
                .map(post -> modelMapper.map(post, postDTO.class))
                .collect(Collectors.toList());
    }
}
