package com.blogapis.blogappforapis.Repository;

import com.blogapis.blogappforapis.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Long> {

}
