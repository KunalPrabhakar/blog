// Import necessary dependencies
import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "../css/CategoryDetailPage.css";
import Base from "../components/Base";
// Define the CategoryDetailPage component
const CategoryDetailPage = () => {
  // State to store the fetched posts
  const [posts, setPosts] = useState([]);
  // Extract the category ID from route parameters
  const { catId } = useParams();
  const [categoryTitle, setCategoryTitle] = useState("");

  // Fetch posts data when the component mounts
  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/api/posts/findByCategory/${catId}`
        );
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        setPosts(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchPosts();
  }, [catId]); // Dependency array ensures fetch is called when catId changes
  useEffect(() => {
    // Wait for postsData state to update before setting the categoryTitle
    if (posts.length > 0) {
      setCategoryTitle(posts[0].categories.catTitle);
    }
  }, [posts]);
  const navigate = useNavigate();

  const handleUser = (userid) => {
    navigate(`/blogs/${userid}`);
  };
  return (
    <Base>
      <div className="container">
        <h1 className="category-heading">
          <h1 className="category-heading">All posts for: {categoryTitle}</h1>
        </h1>
        <div className="posts-container">
          {posts.map((post) => (
            <div key={post.id} className="post-item">
              <h2 className="post-title">{post.title}</h2>
              <p className="post-content">{post.content}</p>
              <p
                className="post-author"
                onClick={() => handleUser(post.user.id)}
              >
                By {post.user.name}
              </p>
            </div>
          ))}
        </div>
      </div>
    </Base>
  );
};

export default CategoryDetailPage;
