package com.woody.ddd.blogcleanarchitechture.adapter.outbound.persistence.blog;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface BlogMapper {
    @Select("select * from blog where id = #{id}")
    Optional<BlogPO> findById(String id);

    @Update("update blog set id = #{blog.id}, title = #{blog.title}, body = #{blog.content} where id = #{blog.id}")
    void update(@Param("Blog") BlogPO blogPO);

    @Insert("insert into blog values (#{blog.id}, #{blog.title}, #{blog.content})")
    void insert(@Param("blog") BlogPO blogPO);
}
