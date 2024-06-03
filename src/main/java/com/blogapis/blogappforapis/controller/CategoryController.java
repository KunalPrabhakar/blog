package com.blogapis.blogappforapis.controller;

import com.blogapis.blogappforapis.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import com.blogapis.blogappforapis.payload.catDTO;
import com.blogapis.blogappforapis.service.catservice;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
   @Autowired
    private catservice catservice;
    @PostMapping("/")
//    @CrossOrigin(origins = "http://localhost:3000") // Replace with your frontend URL
    public ResponseEntity<catDTO> createCategory(@RequestBody catDTO catDto){
        catDTO catcreated=    catservice.createCat(catDto);
        return  new ResponseEntity<>(catcreated, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<catDTO> findCategoryByid(@PathVariable Long id){
        return  new ResponseEntity<>(catservice.getCatById(id), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<catDTO>> findAllCategories(){
        return  new ResponseEntity<>(catservice.getAllCats(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<catDTO> updateCategory(@RequestBody catDTO catDto, @PathVariable Long id){
        return  new ResponseEntity<>(catservice.updateCat(catDto,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        catservice.deleteCatById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
