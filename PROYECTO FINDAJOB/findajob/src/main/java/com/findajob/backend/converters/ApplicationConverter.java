package com.findajob.backend.converters;

import com.findajob.backend.data.ApplicationData;
import com.findajob.backend.entities.Application;

public class ApplicationConverter extends Converter<Application, ApplicationData>{

    private UserConverter userConverter = new UserConverter();
    private VacantConverter vacantConverter = new VacantConverter();
    
    @Override
    public Application toEntity(ApplicationData object) {
        return object == null ? null : Application.builder()
        .id(object.getId())
        .user(userConverter.toEntity(object.getUser()))
        .vacant(vacantConverter.toEntity(object.getVacant()))
        .date(object.getDate())
        .curriculum(object.getCurriculum())
        .comment(object.getComment())
        .build();
    }

    @Override
    public ApplicationData toData(Application object) {
        return object == null ? null : ApplicationData.builder()
        .id(object.getId())
        .user(userConverter.toData(object.getUser()))
        .vacant(vacantConverter.toData(object.getVacant()))
        .date(object.getDate())
        .curriculum(object.getCurriculum())
        .comment(object.getComment())
        .build();
    }
    
}
