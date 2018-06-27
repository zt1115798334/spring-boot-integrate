package com.example.springbootintegrate.mongodb.service.impl;

import com.example.springbootintegrate.mongodb.entity.UserFingerprint;
import com.example.springbootintegrate.mongodb.repository.UserFingerprintRepository;
import com.example.springbootintegrate.mongodb.service.UserFingerprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtong
 * Created by on 2017/12/15
 */
@Service
public class UserFingerprintServiceImpl implements UserFingerprintService {

    @Autowired
    private UserFingerprintRepository userFingerprintRepository;

    @Override
    public UserFingerprint save(UserFingerprint userFingerprint) {
        return userFingerprintRepository.save(userFingerprint);
    }

    @Override
    public List<UserFingerprint> findAll() {
        return userFingerprintRepository.findAll();
    }


}
