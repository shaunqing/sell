package com.pockey.service;

import com.pockey.config.WechatAccountConfig;
import com.pockey.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author LIQing
 * @create 2018-01-23 13:15
 */
@Service
@Slf4j
public class PushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WechatAccountConfig accountConfig;

    /**
     * 订单状态变更消息
     *
     * @param orderDTO
     */
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMsgService = new WxMpTemplateMessage();
        templateMsgService.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
        templateMsgService.setToUser(orderDTO.getBuyerOpenid());

        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData("first","亲，记得收货。"),
                new WxMpTemplateData("keyword1","微信点餐"),
                new WxMpTemplateData("keyword2","13439764353"),
                new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData("keyword5","￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData("remark","欢迎再次光临！")
        );
        templateMsgService.setData(data);

        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMsgService);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}", e);
        }

    }
}
