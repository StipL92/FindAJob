package com.findajob.backend.converters;

import com.findajob.backend.data.VacantData;
import com.findajob.backend.entities.Vacant;

public class VacantConverter extends Converter<Vacant, VacantData> {

    private CategoryConverter categoryConverter = new CategoryConverter();
    
    @Override
    public Vacant toEntity(VacantData object) {
        return object == null ? null : Vacant.builder()
        .id(object.getId())
        .category(categoryConverter.toEntity(object.getCategory()))
        .date(object.getDate())
        .name(object.getName())
        .description(object.getDescription())
        .image(object.getImage())
        .salary(object.getSalary())
        .enable(object.isEnable())
        .build();
    }

    @Override
    public VacantData toData(Vacant object) {
        return object == null ? null : VacantData.builder()
        .id(object.getId())
        .category(categoryConverter.toData(object.getCategory()))
        .date(object.getDate())
        .name(object.getName())
        .description(object.getDescription())
        .image(object.getImage())
        .salary(object.getSalary())
        .enable(object.isEnable())
        .build();
    }
    
}
