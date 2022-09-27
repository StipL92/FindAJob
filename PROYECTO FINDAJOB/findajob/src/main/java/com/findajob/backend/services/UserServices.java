package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.UserConverter;
import com.findajob.backend.data.UserData;
import com.findajob.backend.entities.User;
import com.findajob.backend.repositories.UserRepository;

@Service
public class UserServices {
    
    @Autowired
    private UserRepository userRepository;

    private UserConverter userConverter = new UserConverter();

    //Metodo para registrar o agregar
    public UserData insert(UserData user) {
        if  (userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists!");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    //Servicio que me permite consultas todas los user de la tabala de user
    public List<UserData> findAll() {
        return userConverter.toData(userRepository.findAll());
    }

    //Metodo para consultar user por (id)
    public UserData findById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exist!");
        return userConverter.toData(user.get());
    }

    //Metodo para modificar
    public UserData update(UserData user){
        if (!userRepository.existsById(user.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exits!");
        return userConverter.toData(userRepository.save(userConverter.toEntity(user)));
    }

    //Metodo para Eliminar
    public UserData deleteById(int id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User does not exits!");
        UserData userData = userConverter.toData(user.get());
        userRepository.deleteById(id);
        return userData;
    }
}
