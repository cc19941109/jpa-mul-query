package com.chen.jpareferquery.dao;

import com.chen.jpareferquery.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchoolDao extends JpaRepository<School,Long>,JpaSpecificationExecutor<School>{
}
