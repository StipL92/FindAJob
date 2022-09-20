package com.findajob.backend.data;

import java.sql.Date;

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
public class ApplicationData {
    
    private int id;
    private UserData user;
    private VacantData vacant;
    private Date date;
    private String curriculum;
    private String comment;
    
}
