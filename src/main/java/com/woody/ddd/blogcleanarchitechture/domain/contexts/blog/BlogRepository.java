package com.woody.ddd.blogcleanarchitechture.domain.contexts.blog;

import java.util.Optional;

public interface BlogRepository {
    Optional<Blog> findById(String id);

    Blog save(Blog blog);
}
