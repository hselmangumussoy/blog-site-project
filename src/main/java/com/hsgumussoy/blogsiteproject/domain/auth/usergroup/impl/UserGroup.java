package com.hsgumussoy.blogsiteproject.domain.auth.usergroup.impl;

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
public class UserGroup extends AbstractEntity {
    private String userId;
    private String groupId;
    private Boolean status;
}

