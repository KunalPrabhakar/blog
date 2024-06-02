// src/components/CardContainer.js
import React from "react";
import UserCard from "./Usercard";

const CardContainer = ({ users }) => {
  return (
    <div className="card-container">
      {users.map((user, index) => (
        <UserCard key={index} user={user} />
      ))}
    </div>
  );
};

export default CardContainer;
