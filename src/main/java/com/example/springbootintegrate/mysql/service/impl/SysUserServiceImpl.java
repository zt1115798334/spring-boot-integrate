package com.example.springbootintegrate.mysql.service.impl;

import com.example.springbootintegrate.mysql.entity.SysRole;
import com.example.springbootintegrate.mysql.entity.SysRoleUser;
import com.example.springbootintegrate.mysql.entity.SysUser;
import com.example.springbootintegrate.mysql.repository.SysUserRepository;
import com.example.springbootintegrate.mysql.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhangtong
 * Created by on 2017/11/13
 */
@Transactional
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser save(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public Iterable<SysUser> saveAll(Iterable<SysUser> sysUsers) {
        return sysUserRepository.saveAll(sysUsers);
    }

    @Override
    public Optional<SysUser> findById(Long id) {
        return sysUserRepository.findById(id);
    }

    @Override
    public Iterable<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public Page<SysUser> findPageByEntity(SysUser sysUser) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        sysUserRepository.deleteById(id);
    }

    @Override
    public SysUser findByUserAccountAndUserPassword(String userAccount, String userPassword) {
        return sysUserRepository.findByUserAccountAndUserPassword(userAccount, userPassword);
    }

    @Override
    public SysUser updateLocalDateTime(Long id, LocalDateTime localDateTime) {
        Optional<SysUser> sysUserOptional = sysUserRepository.findById(id);
        SysUser sysUser = null;
        if (sysUserOptional.isPresent()) {
            sysUser = sysUserOptional.get();
            sysUser.setLastLoginTime(localDateTime);
            sysUser = sysUserRepository.save(sysUser);
        }
        return sysUser;
    }

    @Override
    public List<SysRole> findByIdRetSysRole(Long id) {
        Optional<SysUser> sysUserOptional = sysUserRepository.findById(id);
        List<SysRole> result = null;
        SysUser sysUser;
        if (sysUserOptional.isPresent()) {
            sysUser = sysUserOptional.get();
            Set<SysRoleUser> sysRoleUserSet = sysUser.getSysRoleUserSet();
            result = sysRoleUserSet.stream()
                    .map(SysRoleUser::getSysRole)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
