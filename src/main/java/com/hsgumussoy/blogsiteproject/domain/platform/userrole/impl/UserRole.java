package com.hsgumussoy.blogsiteproject.domain.platform.userrole.impl;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserRole  extends AbstractEntity {
    private String userId;
    private String roleId;
}
