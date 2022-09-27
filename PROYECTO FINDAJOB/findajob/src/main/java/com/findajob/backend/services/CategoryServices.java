package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.CategoryConverter;
import com.findajob.backend.data.CategoryData;
import com.findajob.backend.entities.Category;
import com.findajob.backend.repositories.CategoryRepository;

@Service
public class CategoryServices {
    
    @Autowired
    private  CategoryRepository categoryRepository;

    private CategoryConverter categoryConverter = new CategoryConverter();

    //Metodo para registrar o agregar
    public CategoryData insert(CategoryData category){
        if (categoryRepository.existsById(category.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category already exists!");
        return categoryConverter.toData(categoryRepository.save(categoryConverter.toEntity(category)));
    }

    //Servicio que me permite consultas todas las categorias de la tabala categoria
    public List<CategoryData> findAll() {
        return categoryConverter.toData(categoryRepository.findAll());
    }

    //Metodo para consultar por categoria(id)
    public CategoryData findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exits!");
        return categoryConverter.toData(category.get());
    }

    //Metodo para modificar
    public CategoryData update(CategoryData category){
        if (!categoryRepository.existsById(category.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exits!");
        return categoryConverter.toData(categoryRepository.save(categoryConverter.toEntity(category)));
    }

    //Metodo para eliminar
    public CategoryData deleteById(int id){
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category does not exits!");
        CategoryData categoryData = categoryConverter.toData(category.get());
        categoryRepository.deleteById(id);
        return categoryData;
    }
}