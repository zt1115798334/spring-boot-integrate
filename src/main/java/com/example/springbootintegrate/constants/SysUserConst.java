package com.example.springbootintegrate.constants;


import com.example.springbootintegrate.mysql.entity.SysUser;

/**
 * @author zhangtong
 * Created by on 2017/11/17
 */
public class SysUserConst {

    public SysUser getSysUser() {
//        return (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysUser sysUser = new SysUser();
        sysUser.setId(4L);
        sysUser.setUserName("昌平1");
        return sysUser;
    }

    public Long getUserId() {
        return getSysUser().getId();
//        return 4L;
    }

}
