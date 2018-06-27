package com.example.springbootintegrate.mongodb.service;


import com.example.springbootintegrate.mongodb.entity.UserFingerprint;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/12/15
 */
public interface UserFingerprintService {

    UserFingerprint save(UserFingerprint userFingerprint);

    List<UserFingerprint> findAll();
}
