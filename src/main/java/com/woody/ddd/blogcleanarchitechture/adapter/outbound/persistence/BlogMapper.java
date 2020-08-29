package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence;

import com.woody.ddd.blogcleanarchitechture.domain.contexts.blog.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface BlogMapper {
    @Select("select * from blog where id = #{id}")
    Optional<Blog> findById(String id);
}
