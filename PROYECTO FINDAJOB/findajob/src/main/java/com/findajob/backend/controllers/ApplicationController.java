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

import com.findajob.backend.data.ApplicationData;

import com.findajob.backend.services.ApplicationService;

@RestController
@RequestMapping(path = "/api/applications")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;

    //Metodo para registrar en la tabla application
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ApplicationData application) {
        return new ResponseEntity<>(applicationService.insert(application), HttpStatus.CREATED);
    }

    //Metodo para consultar la tabla de application
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(applicationService.findAll(), HttpStatus.OK);
    }

    //Metodo para consultar por application(id)
    @GetMapping("{id}")
    public ResponseEntity<?> finById(@PathVariable int id) {
        return new ResponseEntity<>(applicationService.findById(id), HttpStatus.OK);
    }

    //Metodo para modificar
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ApplicationData category) {
        return new ResponseEntity<>(applicationService.update(category), HttpStatus.OK);
    }

    //Metodo para eliminar
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(applicationService.deleteById(id), HttpStatus.OK);
    }

}
