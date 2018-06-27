package com.example.springbootintegrate.mysql.service.impl;


import com.example.springbootintegrate.mysql.entity.SysRoleUser;
import com.example.springbootintegrate.mysql.repository.SysRoleUserRepository;
import com.example.springbootintegrate.mysql.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/15
 */
@Transactional
@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {
    @Autowired
    private SysRoleUserRepository sysRoleUserRepository;

    @Override
    public SysRoleUser save(SysRoleUser sysRoleUser) {
        return sysRoleUserRepository.save(sysRoleUser);
    }

//    @Override
//    public List<SysRoleUser> findByRoleId(Long roleId) {
//        return sysRoleUserRepository.findByRoleId(roleId);
//    }
//
//    @Override
//    public SysRoleUser findByUserId(Long userId) {
//        return sysRoleUserRepository.findByUserId(userId);
//    }
//
//    @Override
//    public SysRoleUser findByRoleIdAndUserId(Long roleId, Long userId) {
//        return sysRoleUserRepository.findByRoleIdAndUserId(roleId, userId);
//    }
//
//    @Override
//    public void delSysRoleUser(Long userId) {
//        sysRoleUserRepository.deleteByUserId(userId);
//    }

//    @Override
//    public long findCountByRoleId(Long roleId) {
//        return sysRoleUserRepository.countByRoleId(roleId);
//    }
}
