package com.findajob.backend.converters;

import com.findajob.backend.data.UserData;
import com.findajob.backend.entities.User;

public class UserConverter extends Converter<User, UserData> {

    private RoleConverte roleConverter = new RoleConverte();

    @Override
    public User toEntity(UserData object) {
        return object == null ? null : User.builder()
        .id(object.getId())
        .fullname(object.getFullname())
        .nickname(object.getNickname())
        .password(object.getPassword())
        .mail(object.getEmail())
        .enable(object.isEnable())
        .registration(object.getRegistration())
        .roles(roleConverter.toEntity(object.getRoles()))
        .build();
    }

    @Override
    public UserData toData(User object) {
        return object == null ? null : UserData.builder()
        .id(object.getId())
        .fullname(object.getFullname())
        .nickname(object.getNickname())
        .password(null)
        .email(object.getMail())
        .enable(object.isEnable())
        .registration(object.getRegistration())
        .roles(roleConverter.toData(object.getRoles()))
        .build();
    }
    
}
