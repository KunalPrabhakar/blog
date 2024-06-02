// src/components/UserCard.js
import React from "react";
import { useNavigate } from "react-router-dom";

import {
  Card,
  CardBody,
  CardText,
  CardTitle,
  CardSubtitle,
  Button,
} from "reactstrap";

const UserCard = ({ user }) => {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate(`/blogs/${user.id}`);
  };
  return (
    <Card className="user-card">
      <img alt="Sample" src="https://picsum.photos/300/200" />
      <CardBody>
        <CardTitle tag="h5">{user.name}</CardTitle>
        <CardSubtitle className="mb-2 text-muted" tag="h6">
          {user.email}
        </CardSubtitle>
        <CardText>{user.about}</CardText>
        <button onClick={handleClick}>View {user.name} Blogs</button>{" "}
      </CardBody>
    </Card>
  );
};

export default UserCard;
