package com.example.springbootintegrate.mysql.service.impl;

import com.example.springbootintegrate.mysql.entity.SysPermission;
import com.example.springbootintegrate.mysql.entity.SysRolePermission;
import com.example.springbootintegrate.mysql.repository.SysPermissionRepository;
import com.example.springbootintegrate.mysql.service.SysPermissionService;
import com.example.springbootintegrate.mysql.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangtong
 * Created by on 2017/11/14
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysPermission> findAll() {
        return (List<SysPermission>) sysPermissionRepository.findAll();
    }

    @Override
    public boolean saveSysRolePermission(List<String> codes, Long roleId) {
        sysRolePermissionService.deleteByRoleId(roleId);
        List<SysPermission> sysPermissions = sysPermissionRepository.findByCodeIn(codes);
        List<SysRolePermission> sysRolePermissions = sysPermissions.stream()
                .map(sysPermission -> {
                    SysRolePermission sysRolePermission = new SysRolePermission();
                    sysRolePermission.setPermissionId(sysPermission.getId());
                    sysRolePermission.setPermissionCode(sysPermission.getCode());
                    sysRolePermission.setRoleId(roleId);
                    return sysRolePermission;
                }).collect(Collectors.toList());
        sysRolePermissionService.save(sysRolePermissions);
        return true;
    }

    @Override
    public List<SysPermission> findListByRoleIdAndType(Long roleId, String type) {
        List<SysRolePermission> sysRolePermissions = sysRolePermissionService.findByRoleId(roleId);
        List<Long> permissionId = sysRolePermissions.stream()
                .map(SysRolePermission::getPermissionId).collect(Collectors.toList());
        Sort sort = new Sort(Sort.Direction.ASC, "sn");
        return sysPermissionRepository.findByTypeAndIdIn(type, permissionId, sort);
    }

    @Override
    public List<SysPermission> findListByParentId(Long parentId) {
        Sort sort = new Sort(Sort.Direction.ASC, "sn");
        return sysPermissionRepository.findByParentId(parentId, sort);
    }
}
