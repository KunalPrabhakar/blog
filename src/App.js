import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import About from "./pages/About";
import UserBlogsPage from "./pages/UserBlogsPage";
import { BrowserRouter, Routes, Route, Switch } from "react-router-dom";
import Home from "./pages/Home";
import CategoryDetailPage from "./pages/ByCategory";
import NewBlog from "./pages/AddNewBlog";
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />

        <Route path="about" element={<About />} />
        <Route path="/blogs/:userId" element={<UserBlogsPage />} />
        <Route path="/categories/:catId" element={<CategoryDetailPage />} />
        <Route path="/createblog/:userId" element={<NewBlog />} />
        <Route path="/createblog" element={<NewBlog />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
