package com.hsgumussoy.blogsiteproject.domain.platform.role.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity {
    /*Kullanıcıların sisteme erişim ve yetkilerini tanımlar.
    * Roller, belirli bir dizi izni içerir ve bu izinler
    * kullanıcının sistemdeki yetkilerini belirler.*/

    private String name;

}
