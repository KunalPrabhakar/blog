package com.blogapis.blogappforapis.service.impl;

import com.blogapis.blogappforapis.Repository.CategoryRepo;
import com.blogapis.blogappforapis.entities.Categories;
import com.blogapis.blogappforapis.payload.catDTO;
import com.blogapis.blogappforapis.service.catservice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements catservice {

@Autowired
    private CategoryRepo categoryRepo;

@Autowired
private ModelMapper modelMapper;

    @Override
    public catDTO createCat(catDTO catDTO) {
        Categories map=modelMapper.map(catDTO, Categories.class);
        return modelMapper.map(categoryRepo.save(map),catDTO.class);
    }

    @Override
    public catDTO updateCat(catDTO catDTO, Long id) {
        Categories usertobeupdated=     categoryRepo.findById(id).orElse(null);
        usertobeupdated.setCatTitle(catDTO.getCatTitle());
        usertobeupdated.setCatDesc(catDTO.getCatDesc());
        return modelMapper.map(categoryRepo.save(usertobeupdated),catDTO.class);
    }

    @Override
    public catDTO getCatById(Long id) {
        Categories usertobeupdated=     categoryRepo.findById(id).orElse(null);
        return modelMapper.map(usertobeupdated,catDTO.class);
    }

    @Override
    public List<catDTO> getAllCats() {
        List <Categories> allCategories=     categoryRepo.findAll();
      return allCategories.stream().map((cat)->modelMapper.map(cat,catDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteCatById(Long id) {
        Categories usertobeupdated=     categoryRepo.findById(id).orElse(null);
        categoryRepo.delete(usertobeupdated);
    }
}
