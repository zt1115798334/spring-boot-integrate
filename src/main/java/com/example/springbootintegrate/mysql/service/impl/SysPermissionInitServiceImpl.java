package com.example.springbootintegrate.mysql.service.impl;

import com.example.springbootintegrate.mysql.entity.SysPermissionInit;
import com.example.springbootintegrate.mysql.repository.SysPermissionInitRepository;
import com.example.springbootintegrate.mysql.service.SysPermissionInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/14
 */
@Service
public class SysPermissionInitServiceImpl implements SysPermissionInitService {

    @Autowired
    private SysPermissionInitRepository sysPermissionInitRepository;

    @Override
    public List<SysPermissionInit> findAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return sysPermissionInitRepository.findAll(sort);
    }
}
