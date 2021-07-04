package com.kuang.springcloud.service;


import com.kuang.springcloud.pojo.Dept;

import java.util.List;

public interface IDeptService {

    List<Dept> findAll();

    Dept findById(Long id);
}
