package com.pockey.repository;

import com.pockey.domain.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LIQing
 * 2017/12/5 21:25
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
