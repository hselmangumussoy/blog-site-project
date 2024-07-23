package com.hsgumussoy.blogsiteproject.domain.platform.permissionrole.impl;

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
public class PermissionRole extends AbstractEntity {
    private String permissionId;
    private String roleId;

}
