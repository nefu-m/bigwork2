package com.example.bigwork.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int TEACHER_AUTHORITY = 0;
    public static final int ADMIN_AUTHORITY = 1;
    public static final int SUPERADMIN_AUTHORITY = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String title;
    private String introduction;
    private String phone;
    private int authority = 0;
    private int times = 0;

    public User(int id){
        this.id = id;
    }

}
