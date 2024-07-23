package com.hsgumussoy.blogsiteproject.domain.auth.user.web;

import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
