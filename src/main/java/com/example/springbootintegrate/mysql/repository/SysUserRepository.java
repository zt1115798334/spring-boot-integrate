package com.example.springbootintegrate.mysql.repository;

import com.example.springbootintegrate.mysql.entity.SysUser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhangtong
 * Created by on 2017/11/13
 */
public interface SysUserRepository extends CrudRepository<SysUser, Long>, JpaSpecificationExecutor<SysUser> {

    SysUser findByUserAccount(String userAccount);

    SysUser findByUserAccountAndUserPassword(String userAccount, String userPassword);

}
