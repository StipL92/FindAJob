package com.findajob.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.findajob.backend.converters.ApplicationConverter;
import com.findajob.backend.data.ApplicationData;
import com.findajob.backend.entities.Application;
import com.findajob.backend.repositories.ApplicationRepository;

@Service
public class ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

    private ApplicationConverter applicationConverter = new ApplicationConverter();

    //Metodo para registrar
    public ApplicationData insert(ApplicationData application){
        if (applicationRepository.existsById(application.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "application already exists");
        return applicationConverter.toData(applicationRepository.save(applicationConverter.toEntity(application)));
    }

    //Servicio que me permite consultas todas las aplicaciones de la tabla Application
    public List<ApplicationData> findAll() {
        return applicationConverter.toData(applicationRepository.findAll());
    }

        //Metodo para consultar por application(id)
        public ApplicationData findById(int id) {
            Optional<Application> application = applicationRepository.findById(id);
            if (application.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "application does not exists");
            return applicationConverter.toData(application.get());
        }

    //Metodo para actualizar
    public ApplicationData update(ApplicationData application){
        if (!applicationRepository.existsById(application.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "application does not exists");
        return applicationConverter.toData(applicationRepository.save(applicationConverter.toEntity(application)));
    }   
    
    //Metodo para eliminar
    public ApplicationData deleteById(int id) {
        Optional<Application> application =applicationRepository.findById(id);
        if (application.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "application does not exists");
        ApplicationData applicationData = applicationConverter.toData((application.get()));
        applicationRepository.deleteById(id);
        return applicationData;
    }

}