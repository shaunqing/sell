package com.pockey.repository;

import com.pockey.BaseTest;
import com.pockey.domain.SellerInfo;
import com.pockey.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by LIQing
 * 2017/12/5 21:26
 */
public class SellerInfoRepositoryTest extends BaseTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        SellerInfo result = repository.save(sellerInfo);
        Assert.assertTrue("sellerinfo插入", result != null);

    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo sellerInfo = repository.findByOpenid("abc");
        Assert.assertTrue("查找", sellerInfo.getOpenid().equalsIgnoreCase("abc"));
    }


}