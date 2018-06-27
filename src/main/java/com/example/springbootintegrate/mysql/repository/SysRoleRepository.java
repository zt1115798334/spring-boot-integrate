package com.example.springbootintegrate.mysql.repository;

import com.example.springbootintegrate.mysql.entity.SysRole;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author zhangtong
 * Created by on 2017/11/13
 */
public interface SysRoleRepository extends CrudRepository<SysRole, Long>, JpaSpecificationExecutor<SysRole> {

    SysRole findByRoleName(String roleName);

}
