import React, { useState } from "react";
import FormInput from "./FormInput";

const AddCategoryForm = ({ onSubmit }) => {
  const [catTitle, setCatTitle] = useState("");
  const [catDesc, setCatDesc] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    setError(null);

    const category = { catTitle, catDesc };

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
        label="Category Title"
        type="text"
        id="cattitle"
        name="cattitle"
        value={catTitle}
        onChange={(e) => setCatTitle(e.target.value)}
      />
      <FormInput
        label="Category Description"
        type="text"
        id="catdesc"
        name="catdesc"
        value={catDesc}
        onChange={(e) => setCatDesc(e.target.value)}
      />
      <button type="submit">{isSubmitting ? "Submitting..." : "Submit"}</button>
    </form>
  );
};

export default AddCategoryForm;
