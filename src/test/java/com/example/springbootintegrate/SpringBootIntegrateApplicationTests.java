package com.example.springbootintegrate;

import com.example.springbootintegrate.mongodb.service.UserFingerprintService;
import com.example.springbootintegrate.mysql.entity.TestTime;
import com.example.springbootintegrate.mysql.repository.TestTimeRepository;
import com.example.springbootintegrate.mysql.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootIntegrateApplicationTests {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserFingerprintService userFingerprintService;

    @Autowired
    private TestTimeRepository testTimeRepository;

    @Test
    public void contextLoads() {
//        Iterable<SysUser> all = sysUserService.findAll();
//        System.out.println("all = " + all);
//
//        List<SysRole> sysRoleList = sysUserService.findByIdRetSysRole(1L);
//        System.out.println("sysRoleList = " + sysRoleList);
//
//        UserFingerprint userFingerprint = new UserFingerprint();
//        userFingerprint.setFingerprint("1111");
//        userFingerprint.setUserId(1L);
//        userFingerprintService.save(userFingerprint);
//        userFingerprintService.findAll().forEach(System.out::println);

        TestTime testTime = new TestTime();
        testTime.setData(LocalDateTime.now());
        testTimeRepository.save(testTime);
    }

}
