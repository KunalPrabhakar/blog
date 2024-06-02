import NavBar from "./NavBar";

const Base = ({ title = "Welcome to our website", children }) => {
  return (
    <div className="container-fluid">
      {/* <h1>HEADER</h1> */}
      <NavBar />
      {children}
      {/* <h1>Footer</h1> */}
    </div>
  );
};
export default Base;
