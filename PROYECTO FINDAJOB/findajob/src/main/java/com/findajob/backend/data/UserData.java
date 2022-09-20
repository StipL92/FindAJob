package com.findajob.backend.data;

import java.util.Date;
import java.util.List;

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
public class UserData {
    
    private int id;
    private String fullname;
    private String nickname;
    private String email;
    private String password;
    private boolean enable;
    private Date registration;
    private List<RoleData> roles;
}
