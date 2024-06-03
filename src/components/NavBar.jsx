import React, { useState } from "react";
import {
  NavLink as ReactLink,
  useNavigate,
  useParams,
  useLocation,
} from "react-router-dom";

import {
  Navbar,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
  Collapse,
  NavbarToggler,
} from "reactstrap";

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);
  let { userId } = useParams();

  const args = {
    color: "light",
    light: true,
    expand: "md",
  };
  const navigate = useNavigate();

  const addNewBlog = (userId) => {
    if (userId) {
      navigate(`/createblog/${userId}`);
    } else {
      navigate(`/createblog`);
    }
  };
  const location = useLocation();

  const shouldHideNavbarText = location.pathname.includes("createblog");

  return (
    <div>
      <Navbar {...args}>
        <NavbarBrand href="/">My Blogs</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink tag={ReactLink} to="/about">
                About
              </NavLink>
            </NavItem>
            {/* <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                Options
              </DropdownToggle>
              <DropdownMenu end>
                <DropdownItem>Option 1</DropdownItem>
                <DropdownItem>Option 2</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>Reset</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown> */}
          </Nav>
          {!shouldHideNavbarText && (
            <NavbarText
              onClick={() => addNewBlog(userId)}
              style={{ cursor: "pointer" }}
            >
              Click here to add new blog
            </NavbarText>
          )}
        </Collapse>
      </Navbar>
    </div>
  );
};

export default NavBar;
