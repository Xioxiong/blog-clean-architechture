package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.blog;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MyBatisBlogRepository implements BlogRepository {
    private final BlogMapper blogMapper;

    public MyBatisBlogRepository(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Override
    public Optional<Blog> findById(String id) {
        return blogMapper.findById(id).map(BlogPO::toDomainModel);
    }

    @Override
    public Blog save(Blog blog) {
        BlogPO blogPO = BlogPO.of(blog);

        Optional<BlogPO> existingBlog = blogMapper.findById(blog.getId());

        if (existingBlog.isPresent()) {
            blogMapper.update(blogPO);
        } else {
            blogMapper.insert(blogPO);
        }
        return blog;
    }
}
