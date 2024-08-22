package com.hsgumussoy.blogsiteproject.domain.auth.user.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    private String userName;
    private String email;
    private String password;
    private String phoneNumber;

    private UserType userType;
}
