package com.hsgumussoy.blogsiteproject.domain.platform.follow.impl.userfollow;

import com.hsgumussoy.blogsiteproject.library.rest.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserFollow extends AbstractEntity {
    private String userId;
    private String followId;
}
