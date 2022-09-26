package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.RoleConverte;
import com.findajob.backend.data.RoleData;
import com.findajob.backend.entities.Role;
import com.findajob.backend.repositories.RoleRepository;

@Service
public class RoleServices {
    
    @Autowired
    private RoleRepository roleRepository;

    private RoleConverte roleConverte = new RoleConverte();

    //Metodo para registrar o agregar
    public RoleData insert(RoleData role){
        if (roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exists!");
        return roleConverte.toData(roleRepository.save(roleConverte.toEntity(role)));
    }

    //Servicio que me permite consultas todos los roles de la tabla de roles
    public List<RoleData>findAll(){
        return roleConverte.toData(roleRepository.findAll());
    }

    //Metodo para consultar por roles(id)
    public RoleData findById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role does not exits!");
        return roleConverte.toData(role.get());
    }

    //Metodo para modificar
    public RoleData update(RoleData role){
        if (!roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role does not exits!");
        return roleConverte.toData(roleRepository.save(roleConverte.toEntity(role)));
    }

    //Metodo para eliminar
    public RoleData deleteById(int id){
        Optional<Role> role = roleRepository.findById(id);
        if (role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role does not exits!");
        roleRepository.deleteById(id);
        return roleConverte.toData(role.get());
    }

}
