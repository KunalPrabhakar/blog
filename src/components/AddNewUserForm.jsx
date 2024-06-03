import React, { useState } from "react";
import FormInput from "./FormInput";

const AddNewUserForm = ({ onSubmit }) => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [about, setAbout] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [error, setError] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    setIsSubmitting(true);
    setError(null);

    const user = { name, email, password, about };

    onSubmit(user)
      .then(() => {
        console.log("new user added");
        setIsSubmitting(false);
      })
      .catch((err) => {
        setError("Error adding user: " + err.message);
        setIsSubmitting(false);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      {error && <div className="error">{error}</div>}
      <FormInput
        label="User Name"
        type="text"
        id="username"
        name="username"
        value={name}
        onChange={(e) => setName(e.target.value)}
        disabled={isSubmitting}
        required
      />
      <FormInput
        label="User Email"
        type="email"
        id="useremail"
        name="useremail"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        disabled={isSubmitting}
        required
      />
      <FormInput
        label="User Password"
        type="password"
        id="userpassword"
        name="userpassword"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        disabled={isSubmitting}
        required
      />
      <FormInput
        label="About User"
        type="text"
        id="aboutuser"
        name="aboutuser"
        value={about}
        onChange={(e) => setAbout(e.target.value)}
        required
      />
      <button type="submit">{isSubmitting ? "Submitting..." : "Submit"}</button>
    </form>
  );
};

export default AddNewUserForm;
