package com.example.springbootintegrate.mysql.service;

import com.example.springbootintegrate.base.dao.BaseDao;
import com.example.springbootintegrate.mysql.entity.SysRole;
import com.example.springbootintegrate.mysql.entity.SysUser;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/13
 */
public interface SysUserService extends BaseDao<SysUser> {

    /**
     * 根据账户密码查询账户信息
     *
     * @param userAccount  账户
     * @param userPassword
     * @return
     */
    SysUser findByUserAccountAndUserPassword(String userAccount, String userPassword);

    /**
     * 更新最后一次登录时间
     *
     * @param id            id
     * @param localDateTime 最后一次登录时间
     * @return
     */
    SysUser updateLocalDateTime(Long id, LocalDateTime localDateTime);

    /**
     * 根据userId查询用户角色信息
     * @param id
     * @return
     */
    List<SysRole> findByIdRetSysRole(Long id);
}
