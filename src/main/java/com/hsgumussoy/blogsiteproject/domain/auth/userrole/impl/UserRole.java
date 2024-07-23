package com.hsgumussoy.blogsiteproject.domain.auth.userrole.impl;

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
public class UserRole  extends AbstractEntity {
    private String userId;
    private String roleId;
    private Boolean status;
}

