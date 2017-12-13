package com.pockey.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author LIQing
 * @create 2017-12-11 16:16
 */
@Data
@ConfigurationProperties(prefix = "projectUrl")
@Component
public class ProjectUrlConfig {

    // 微信公众平台授权url
    public String wechatMpAuthorize;

    // 微信开放平台授权url
    public String wechatOpenAuthorize;

    // 系统url
    public String sell;
}
