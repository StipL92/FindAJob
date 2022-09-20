package com.findajob.backend.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String fullname;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false, unique = true)
    private String mail;

    @Getter(value = AccessLevel.NONE)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enable;

    @Column(nullable = false)
    private Date registration;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private List<Role> roles;

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }
}
