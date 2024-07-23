package com.hsgumussoy.blogsiteproject.domain.auth.auth.api;

import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
    private String email;
    private String password;
    private UserType userType;
}
