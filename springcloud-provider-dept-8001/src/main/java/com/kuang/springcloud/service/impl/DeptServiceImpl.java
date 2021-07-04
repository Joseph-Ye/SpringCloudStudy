package com.kuang.springcloud.service.impl;

import com.kuang.springcloud.dao.IDeptDao;
import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDao deptDao;

    public List<Dept> findAll() {
        return deptDao.findAll();
    }


    public Dept findById(Long id) {
        return deptDao.findById(id).get();
    }


}
