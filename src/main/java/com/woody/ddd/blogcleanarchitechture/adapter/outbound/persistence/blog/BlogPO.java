package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.blog;

import com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.PersistenceObject;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlogPO implements PersistenceObject<Blog> {
    private final String id;
    private final String title;
    private final String content;

    public static BlogPO of(Blog blog) {
        return new BlogPO(blog.getId(), blog.getTitle(), blog.getContent());
    }

    @Override
    public Blog toDomainModel() {
        return new Blog(this.getId(), this.getTitle(), this.getContent());
    }
}
