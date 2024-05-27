package com.blogapis.blogappforapis.service;

import com.blogapis.blogappforapis.payload.catDTO;

import java.util.List;

public interface catservice {
    catDTO createCat(catDTO catDTO);
    catDTO updateCat(catDTO catDTO, Long id);
    catDTO getCatById(Long id);
    List<catDTO> getAllCats();
    void deleteCatById(Long id);
}
