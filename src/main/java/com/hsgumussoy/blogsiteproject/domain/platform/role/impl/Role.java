package com.hsgumussoy.blogsiteproject.domain.platform.role.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role extends AbstractEntity {
    private RoleName name;

}
