package com.kuang.springcloud.dao;


import com.kuang.springcloud.pojo.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeptDao extends JpaRepository<Dept, Long> {
    List<Dept> findAll();

}
