package com.pockey.service;

import com.pockey.BaseTest;
import com.pockey.domain.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/12/5 21:39
 */
public class SellerServiceTest extends BaseTest{

    private static final String openid = "abc";

    @Autowired
    private SellerService sellerService;

    @Test
    public void findSellerInfoByOpenid() throws Exception {
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        Assert.assertTrue("查找",sellerInfo.getOpenid().equals(openid));
    }

}