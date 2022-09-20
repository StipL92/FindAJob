package com.findajob.backend.data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacantData {
    
    private int id;
    private CategoryData category;
    private Date date;
    private String name;
    private String description;
    private double salary;
    private String image;
    private boolean enable;

    
}
