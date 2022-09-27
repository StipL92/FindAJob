package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.VacantConverter;
import com.findajob.backend.data.VacantData;
import com.findajob.backend.entities.Vacant;
import com.findajob.backend.repositories.VacantRepository;

@Service
public class VacantService {
    
    @Autowired
    private VacantRepository vacantRepository;

    private VacantConverter vacantConverter = new VacantConverter();

    //Metodo para registrar o agregar
    public VacantData insert(VacantData vacant){
        if (vacantRepository.existsById(vacant.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Vacant already exists!");
        return vacantConverter.toData(vacantRepository.save(vacantConverter.toEntity(vacant)));
    }

    //Servicio que me permite consultas todos los roles de la tabla de roles
    public List<VacantData>findAll(){
        return vacantConverter.toData(vacantRepository.findAll());
    }

    //Metodo para consultar por roles(id)
    public VacantData findById(int id) {
        Optional<Vacant> vacant = vacantRepository.findById(id);
        if (vacant.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacant does not exits!");
        return vacantConverter.toData(vacant.get());
    }

    //Metodo para modificar
    public VacantData update(VacantData vacant){
        if (!vacantRepository.existsById(vacant.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacant does not exits!");
        return vacantConverter.toData(vacantRepository.save(vacantConverter.toEntity(vacant)));
    }

    //Metodo para eliminar
    
    public VacantData deleteById(int id){
        Optional<Vacant> vacant = vacantRepository.findById(id);
        if (vacant.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vacant does not exits!");
        VacantData vacantData = vacantConverter.toData(vacant.get());
        vacantRepository.deleteById(id);
        return vacantData; 
    }

}