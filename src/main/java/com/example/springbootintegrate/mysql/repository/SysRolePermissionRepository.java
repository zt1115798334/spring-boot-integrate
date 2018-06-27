package com.example.springbootintegrate.mysql.repository;

import com.example.springbootintegrate.mysql.entity.SysRolePermission;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/14
 */
public interface SysRolePermissionRepository extends CrudRepository<SysRolePermission, Long> {

    void  deleteByRoleId(Long roleId);

    List<SysRolePermission> findByRoleId(Long roleId);
}
