import React, { useState } from "react";
import FormInput from "./FormInput";

const AddPostForm = ({ onSubmit }) => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    setError(null);

    const category = { title, content };

    onSubmit(category)
      .then(() => {
        console.log("new category added");
        setIsSubmitting(false);
      })
      .catch((err) => {
        setError("Error adding category: " + err.message);
        setIsSubmitting(false);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      {error && <div className="error">{error}</div>}
      <FormInput
        label="Post Title"
        type="text"
        id="postTitle"
        name="posttitle"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <FormInput
        label="Post Content"
        type="text"
        id="postcontent"
        name="postContent"
        value={content}
        onChange={(e) => setContent(e.target.value)}
      />
      <button type="submit">{isSubmitting ? "Submitting..." : "Submit"}</button>
    </form>
  );
};

export default AddPostForm;
