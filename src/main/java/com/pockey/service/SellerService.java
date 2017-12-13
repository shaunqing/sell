package com.pockey.service;

import com.pockey.domain.SellerInfo;
import com.pockey.repository.SellerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LIQing
 * 2017/12/5 21:37
 */
@Service
public class SellerService {

    @Autowired
    private SellerInfoRepository repository;

    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
