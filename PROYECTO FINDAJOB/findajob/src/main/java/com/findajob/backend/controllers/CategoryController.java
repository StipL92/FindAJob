package com.findajob.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findajob.backend.data.CategoryData;
import com.findajob.backend.services.CategoryServices;

@RestController
@RequestMapping(path = "/api/categories")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    
    @Autowired
    private CategoryServices categoryServices;

    //Metodo para registrar la tabla de category
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CategoryData category){
        return new ResponseEntity<>(categoryServices.insert(category), HttpStatus.CREATED);
    }

    //Metodo para consultar la tabla de category
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(categoryServices.findAll(), HttpStatus.OK);

    }

    //Metodo para consultar por categoria(id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(categoryServices.findById(id), HttpStatus.OK);
    }

    //Metodo para modificar-editar
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CategoryData category){
        return new ResponseEntity<>(categoryServices.update(category), HttpStatus.OK);
    }

    //Metodo para eliminar
    @DeleteMapping ("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(categoryServices.deleteById(id), HttpStatus.OK);
    }



}
