package com.hsgumussoy.blogsiteproject.domain.platform.permissiongroup.impl;

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
public class PermissionGroup extends AbstractEntity {
    /*İzin ile rol arasındaki ilişkiyi tanımlar.
    * Bir rol, bir veya daha fazla izne sahip olabilir
    * ve bir izin birden fazla rolde bulunabilir.*/

    private String permissionId;
    private String roleId;

}
