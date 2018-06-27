package com.example.springbootintegrate.mysql.service.impl;


import com.example.springbootintegrate.constants.SysConst;
import com.example.springbootintegrate.constants.SysUserConst;
import com.example.springbootintegrate.mysql.entity.SysRole;
import com.example.springbootintegrate.mysql.repository.SysRoleRepository;
import com.example.springbootintegrate.mysql.service.SysRoleService;
import com.example.springbootintegrate.mysql.service.SysRoleUserService;
import com.example.springbootintegrate.utils.DateUtils;
import com.example.springbootintegrate.utils.PageUtils;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/11/13
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysRoleUserService sysRoleUserService;


    @Override
    public boolean save(SysRole sysRole) {
        String roleName = sysRole.getRoleName();
        boolean isExist = isExistByRoleName(roleName);
        if (isExist) {
            return false;
        } else {
            Long userId = new SysUserConst().getUserId();
            LocalDate currentDate = DateUtils.currentDate();
            LocalDateTime currentDatetime = DateUtils.currentDatetime();
            sysRole.setRoleType(SysConst.RoleType.OPERATION.getCode());
            sysRole.setCreatedDate(currentDate);
            sysRole.setCreatedDatetime(currentDatetime);
            sysRole.setCreatedUserId(userId);
            sysRole.setModifiedDate(currentDate);
            sysRole.setModifiedDatetime(currentDatetime);
            sysRole.setModifiedUserId(userId);
            sysRoleRepository.save(sysRole);
            return true;
        }
    }

    @Override
    public List<SysRole> findList() {
        return (List<SysRole>) sysRoleRepository.findAll();
    }

    @Override
    public Page<SysRole> findPage(String roleName, int pageNumber, int pageSize) {
        Specification<SysRole> specification = new Specification<SysRole>() {
            @Override
            public Predicate toPredicate(Root<SysRole> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = Lists.newArrayList();
                predicates.add(builder.like(root.get("roleName").as(String.class), "%" + roleName + "%"));
                Predicate[] pre = new Predicate[predicates.size()];
                query.where(predicates.toArray(pre));

                return builder.and(predicates.toArray(pre));
            }
        };
        Pageable pageable = PageUtils.buildPageRequest(pageNumber,
                pageSize,
                "id");
        return sysRoleRepository.findAll(specification, pageable);

    }

    @Override
    public boolean delSysRole(Long id) {
//        long userCount = sysRoleUserService.findCountByRoleId(id);
//        if (userCount > 0) {
//            return false;
//        } else {
//            sysRoleRepository.deleteById(id);
//            return true;
//        }
        return true;
    }

    @Override
    public boolean isExistByRoleName(String roleName) {
        SysRole isExist = sysRoleRepository.findByRoleName(roleName);
        return isExist != null;
    }

    @Override
    public List<SysRole> findListByUserId(Long userId) {
        return null;
    }
}
