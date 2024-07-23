package com.hsgumussoy.blogsiteproject.domain.auth.auth.impl;

import com.hsgumussoy.blogsiteproject.domain.auth.auth.api.LoginDto;
import com.hsgumussoy.blogsiteproject.domain.auth.auth.api.RegisterDto;
import com.hsgumussoy.blogsiteproject.domain.auth.auth.web.LoginRequest;
import com.hsgumussoy.blogsiteproject.domain.auth.auth.web.RegisterRequest;
import com.hsgumussoy.blogsiteproject.domain.auth.user.impl.UserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthMapper {
    public static RegisterDto toRegisterDto(RegisterRequest request, UserType userType) {
        return RegisterDto.builder()
                .email(request.email())
                .password(request.password())
                .userType(userType)
                .build();
    }

    public static LoginDto toLoginDto(LoginRequest request, UserType userType) {
        return LoginDto.builder()
                .email(request.email())
                .password(request.password())
                .userType(userType)
                .build();
    }
    
    /*@NoArgsConstructor(access = AccessLevel.PRIVATE) adnotasyonu, 
    Lombok kütüphanesinin sağladığı bir özelliktir ve sınıfınıza
    bir no-arg (parametresiz) yapıcı (constructor) ekler. 
    AccessLevel.PRIVATE belirterek, bu yapıcının erişim seviyesini 
    özel (private) yapar. Bu, yapıcıya yalnızca sınıf içinden 
    erişilebileceği anlamına gelir. Bu şekilde, dışarıdan nesne 
    oluşturulmasını engelleyebilir ve sınıfınızı yalnızca statik 
    metodlarla kullanılabilir hale getirebilirsiniz.

    Bu kullanım genellikle şu amaçlarla tercih edilir:

    Singleton Pattern: Singleton tasarım deseninde, sınıfın 
    yalnızca bir örneği olması gerektiğinde, no-arg yapıcının 
    özel olması sağlanır ve sınıf dışından nesne oluşturulması engellenir.

    Utility Classes: Yardımcı sınıflar (utility classes) 
    genellikle yalnızca statik metodlar içerir. Bu tür sınıflarda 
    da nesne oluşturulmasını engellemek için no-arg yapıcı özel yapılır.*/
}
