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

import com.findajob.backend.data.UserData;
import com.findajob.backend.services.UserServices;

@RestController
@RequestMapping( path = "/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private UserServices userServices;

    //Metodo para registrar la tabla de 
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserData user){
        return new ResponseEntity<>(userServices.insert(user), HttpStatus.CREATED);
    }

    //Metodo para consultar la tabla de user
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(userServices.findAll(), HttpStatus.OK);
    }

    //Metodo para consultar por user(id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(userServices.findById(id), HttpStatus.OK);
    }

    //Metodo para modificar-editar
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserData user){
        return new ResponseEntity<>(userServices.update(user), HttpStatus.OK);
    }

    //Metodo para eliminar
    @DeleteMapping ("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(userServices.deleteById(id), HttpStatus.OK);
    }
}
