import React, { useState } from "react";
import Base from "../components/Base";
import AddNewUserForm from "../components/AddNewUserForm";
import AddCategoryForm from "../components/AddCategoryForm";
import "../css/NewBlog.css";
import AddPostForm from "../components/AddPost";

const NewBlog = () => {
  const [userName, setUserName] = useState("");
  const [catId, setCatId] = useState(0);
  const [userId, setuserId] = useState(0);

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
        setuserId(data.id); // Set the user's name after adding the user
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
      `http://localhost:8080/api/posts/user/${userId}/category/${catId}/post`,
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
      .then(() => {
        console.log("new post added");
        // setUserName(user.name); // Set the user's name after adding the user
      });
  };
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
      <div className="create">
        <h2>Add User</h2>
        <AddNewUserForm onSubmit={addUser} />
      </div>
      {userName && (
        <>
          <h4 className="category-selection-heading">
            Hi! {userName}, please select the category you want to make a blog
            of
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
          </div>
        </>
      )}
    </Base>
  );
};

export default NewBlog;
