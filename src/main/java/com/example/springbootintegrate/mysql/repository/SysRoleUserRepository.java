package com.example.springbootintegrate.mysql.repository;

import com.example.springbootintegrate.mysql.entity.SysRoleUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/14
 */
public interface SysRoleUserRepository extends CrudRepository<SysRoleUser, Long> {

}
