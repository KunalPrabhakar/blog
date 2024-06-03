import React from "react";

const FormInput = ({ label, type, id, name, value, onChange }) => {
  return (
    <div className="form-input">
      <label htmlFor={id}>{label}</label>
      <input
        type={type}
        id={id}
        name={name}
        value={value}
        onChange={onChange}
        required
      />
    </div>
  );
};

export default FormInput;
