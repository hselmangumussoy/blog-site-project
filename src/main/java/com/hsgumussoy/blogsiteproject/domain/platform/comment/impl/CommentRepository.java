package com.hsgumussoy.blogsiteproject.domain.platform.comment.impl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
