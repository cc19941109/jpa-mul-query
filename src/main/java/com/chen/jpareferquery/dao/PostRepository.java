package com.chen.jpareferquery.dao;

import com.chen.jpareferquery.entity.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedEntityGraph;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>,JpaSpecificationExecutor<Post>{

    @Query("SELECT p FROM Post p JOIN FETCH p.comments WHERE p.id = (:id)")
    Post findByIdAndFetchCommentsEagerly(@Param("id") Long id);

}