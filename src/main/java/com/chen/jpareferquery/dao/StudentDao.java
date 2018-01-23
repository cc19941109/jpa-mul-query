package com.chen.jpareferquery.dao;

import com.chen.jpareferquery.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDao extends JpaRepository<Student,Long>,JpaSpecificationExecutor<Student> {

}
