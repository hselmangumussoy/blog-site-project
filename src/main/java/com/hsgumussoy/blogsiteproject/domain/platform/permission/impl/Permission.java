package com.hsgumussoy.blogsiteproject.domain.platform.permission.impl;

import com.hsgumussoy.blogsiteproject.domain.platform.permission.api.PermissionType;
import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends AbstractEntity {
    /*Sistemdeki belirli işlemleri gerçekleştirmek
    için gerekli izinleri tanımlar. İzinler, genellikle
    rol ve kullanıcı yetkilendirmeleriyle ilişkilidir.*/

    private String name;
    private String description;
    private PermissionType permissionType;
}
