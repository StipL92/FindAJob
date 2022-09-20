package com.findajob.backend.converters;

import com.findajob.backend.data.CategoryData;
import com.findajob.backend.entities.Category;

public class CategoryConverter extends Converter<Category, CategoryData> {

    @Override
    public Category toEntity(CategoryData object) {
        return object == null ? null : Category.builder()
        .id(object.getId())
        .name(object.getName())
        .descripcion(object.getDescripcion())
        .build();

    }

    @Override
    public CategoryData toData(Category object) {
        return object == null ? null : CategoryData.builder()
        .id(object.getId())
        .name(object.getName())
        .descripcion(object.getDescripcion())
        .build();
        
    }
    

}
