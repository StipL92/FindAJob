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

import com.findajob.backend.data.VacantData;
import com.findajob.backend.services.VacantService;




@RestController
@RequestMapping(path = "/api/vacancies")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VacantController {
    
    @Autowired
    private VacantService vacantService;

    //Metodo para registrar la tabla de vacant
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VacantData vacant){
        return new ResponseEntity<>(vacantService.insert(vacant), HttpStatus.CREATED);
    }

    //Metodo para consultar la tabla de vacant
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(vacantService.findAll(), HttpStatus.OK);
    }

    //Metodo para consultar por vacant(id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(vacantService.findById(id), HttpStatus.OK);
    }

    //Metodo para modificar-editar
    @PutMapping
    public ResponseEntity<?> update(@RequestBody VacantData vacant){
        return new ResponseEntity<>(vacantService.update(vacant), HttpStatus.OK);
    }

    //Metodo para eliminar
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(vacantService.deleteById(id), HttpStatus.OK);
    }
}
