// src/components/Home.js
import React, { useState, useEffect } from "react";
import Base from "../components/Base";
import CardContainer from "../components/CardContainer";
import "../css/Home.css"; // Import the CSS file

const Home = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/api/user/findall", {
          method: "GET",
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();

        // Set state with the fetched data
        setUsers(data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      <Base>
        <div class="header-container">
          <h1 class="styled-heading">
            Select the Author Whose Blogs You'd Like to Explore
          </h1>
        </div>
        <CardContainer users={users} />
      </Base>
    </div>
  );
};

export default Home;
