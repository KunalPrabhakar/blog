import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "../css/UserBlogsPage.css"; // Assuming you create a CSS file for styling
import Base from "../components/Base";

const UserBlogsPage = () => {
  const { userId } = useParams();
  const [blogs, setBlogs] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchBlogs = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/api/posts/findByUser/${userId}`
        );
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        const data = await response.json();
        setBlogs(data);
      } catch (error) {
        setError(error);
      }
    };

    fetchBlogs();
  }, [userId]);
  const navigate = useNavigate();

  const handleCategoryClick = (categoryId) => {
    navigate(`/categories/${categoryId}`);
  };
  return (
    <Base>
      <div className="blogs-container">
        {error && <div className="error-message">Error: {error.message}</div>}
        {blogs.length === 0 ? (
          <div className="no-blogs-message">No blogs found for this user.</div>
        ) : (
          <ul className="blogs-list">
            {blogs.map((blog) => (
              <li key={blog.id} className="blog-item">
                <h2 className="blog-title">{blog.title}</h2>
                <p className="blog-content">{blog.content}</p>
                <p
                  className="blog-category"
                  onClick={() => handleCategoryClick(blog.categories.catId)}
                >
                  <strong>Category:</strong> {blog.categories.catTitle}
                </p>
              </li>
            ))}
          </ul>
        )}
      </div>
    </Base>
  );
};

export default UserBlogsPage;
