package com.findajob.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.findajob.backend.converters.CategoryConverter;
import com.findajob.backend.data.CategoryData;
import com.findajob.backend.repositories.CategoryRepository;

@Service
public class CategoryServices {
    
    @Autowired
    private  CategoryRepository categoryRepository;

    private CategoryConverter categoryConverter = new CategoryConverter();

    //Servicio que me permite consultas todas las categorias de la tabala categoria
    public List<CategoryData> findall() {
        return categoryConverter.toData(categoryRepository.findAll());

    }
}
