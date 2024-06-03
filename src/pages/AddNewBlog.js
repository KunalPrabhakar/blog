import React, { useState, useEffect } from "react";
import Base from "../components/Base";
import AddNewUserForm from "../components/AddNewUserForm";
import AddCategoryForm from "../components/AddCategoryForm";
import "../css/NewBlog.css";
import AddPostForm from "../components/AddPost";
import { Link, useParams } from "react-router-dom";

const NewBlog = () => {
  let { userId } = useParams();
  const [userName, setUserName] = useState("");
  const [catId, setCatId] = useState(0);
  const [uID, setuID] = useState(userId);
  const [blogId, setBlogId] = useState(0);

  const addUser = (user) => {
    return fetch(`http://localhost:8080/api/user/`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(user),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        console.log("new user added");
        setUserName(user.name);
        setuID(data.id); // Set the user's name after adding the user
      });
  };

  const addCategory = (category) => {
    return fetch(`http://localhost:8080/api/category/`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(category),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        // console.log(response.json());
        return response.json();
      })
      .then((data) => {
        console.log("new category added");
        setCatId(data.catId); // Set the user's name after adding the user
      });
  };
  const addPost = (user) => {
    return fetch(
      `http://localhost:8080/api/posts/user/${uID}/category/${catId}/post`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      }
    )
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setBlogId(data.postId);
        console.log("new post added");
        // setUserName(user.name); // Set the user's name after adding the user
      });
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        if (uID !== 0) {
          const response = await fetch(
            `http://localhost:8080/api/user/finduser/${uID}`
          );
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          const data = await response.json();
          setUserName(data.name);
        }
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, [uID]);
  // const addCategory = (category) => {
  //   fetch(`http://localhost:8080/api/category/`, {
  //     method: "POST",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify(category),
  //   }).then(() => {
  //     console.log("new category added");
  //   });
  // };

  return (
    <Base>
      {!uID && (
        <div className="create">
          <h2>Add User</h2>
          <AddNewUserForm onSubmit={addUser} />
        </div>
      )}
      {userName && (
        <>
          <h4 className="category-selection-heading">
            Hi! {userName} please select the category you want to make a blog of
          </h4>
          <div className="create">
            <h2>Add Category</h2>
            <AddCategoryForm onSubmit={addCategory} />
          </div>
        </>
      )}
      {catId !== 0 && (
        <>
          <h4 className="category-selection-heading">Let's create post</h4>
          <div className="create">
            <h2>Now lets create a post</h2>
            <AddPostForm onSubmit={addPost} />
            {blogId !== 0 && ( // Check if catId is not empty
              <div className="post-created">
                <p>Your post has been created!</p>
                <Link to={`/blogs/${uID}`} className="view-post-link">
                  Click here to view all your blogs
                </Link>
              </div>
            )}
          </div>
        </>
      )}
    </Base>
  );
};

export default NewBlog;
