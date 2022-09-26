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

import com.findajob.backend.data.RoleData;
import com.findajob.backend.services.RoleServices;

@RestController
@RequestMapping(path = "/api/roles")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoleController {
    
    @Autowired
    private RoleServices roleServices;

    //Metodo para registrar la tabla de role
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleData role){
        return new ResponseEntity<>(roleServices.insert(role), HttpStatus.CREATED);
    }

    //Metodo para consultar la tabla de Role
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(roleServices.findAll(), HttpStatus.OK);
    }

    //Metodo para consultar por role(id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(roleServices.findById(id), HttpStatus.OK);
    }

    //Metodo para modificar-editar
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoleData role){
        return new ResponseEntity<>(roleServices.update(role), HttpStatus.OK);
    }

    //Metodo para eliminar
    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(roleServices.deleteById(id), HttpStatus.OK);
    }

}
