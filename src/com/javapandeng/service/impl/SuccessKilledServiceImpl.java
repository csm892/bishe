package com.javapandeng.service.impl;

import com.javapandeng.base.BaseDao;
import com.javapandeng.base.BaseServiceImpl;
import com.javapandeng.mapper.SuccessKilledMapper;
import com.javapandeng.mapper.UserMapper;
import com.javapandeng.po.SuccessKilled;
import com.javapandeng.po.User;
import com.javapandeng.service.SuccessKillerService;
import com.javapandeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuccessKilledServiceImpl extends BaseServiceImpl<SuccessKilled> implements SuccessKillerService {
    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Override
    public BaseDao<SuccessKilled> getBaseDao() {
        return successKilledMapper;
    }
}
