package com.dm.push.scheduler.service;

import com.dm.push.properties.WxProperties;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

/**
 * 微信服务
 *
 * @author dm
 * @date 2022/08/26
 */
@Service
@RequiredArgsConstructor
public class WxService {

    private final WxProperties wxProperties;

    public void push() {

        // push Logic
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(wxProperties.getAppId());
        wxStorage.setSecret(wxProperties.getSecret());
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("xx")
                .templateId("xx")
                .build();

        // TODO
    }
}
