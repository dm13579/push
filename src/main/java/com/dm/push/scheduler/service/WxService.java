package com.dm.push.scheduler.service;

import com.dm.push.api.TianApiService;
import com.dm.push.api.WeatherService;
import com.dm.push.entity.TianEnsentenceEntity;
import com.dm.push.entity.Weather;
import com.dm.push.properties.WxProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

/**
 * 微信服务
 *
 * @author dm
 * @date 2022/08/26
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class WxService {

    private final WxProperties wxProperties;
    private final WeatherService weatherService;
    private final TianApiService tianApiService;

    public void push() {

        try {
            // push Logic
            // 配置
            WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
            wxStorage.setAppId(wxProperties.getAppId());
            wxStorage.setSecret(wxProperties.getSecret());
            WxMpService wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(wxStorage);
            for (String userId : wxProperties.getUserIds()) {
                // 定制模板
                WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                        .toUser(userId)
                        .templateId(wxProperties.getTemplateId())
                        .build();

                //今天是{{date.DATA}}
                //天气现象{{weather_text.DATA}}
                //今天温度{{weather_low.DATA}}度到{{weather_high.DATA}}度
                //现在是{{weather_temp.DATA}}度
                //风力等级{{weather_windclass.DATA}}
                //风向{{weather_winddir.DATA}}
                //每日一语 {{caihongp.DATAi}}
                //今日英语 {{en.DATA}}
                //翻译 {{zh.DATA}}
                Weather weather = weatherService.getWeather();
                TianEnsentenceEntity ensentence = tianApiService.getEnsentence();
                templateMessage.addData(new WxMpTemplateData("date", weather.getDate() + "  " + weather.getWeek(), "#00BFFF"));
                templateMessage.addData(new WxMpTemplateData("weather_text", weather.getText(), "#00FFFF"));
                templateMessage.addData(new WxMpTemplateData("weather_low", weather.getLow() + "", "#173177"));
                templateMessage.addData(new WxMpTemplateData("weather_temp", weather.getTemp() + "", "#EE212D"));
                templateMessage.addData(new WxMpTemplateData("weather_high", weather.getHigh() + "", "#FF6347"));
                templateMessage.addData(new WxMpTemplateData("weather_windclass", weather.getWind_class() + "", "#42B857"));
                templateMessage.addData(new WxMpTemplateData("weather_winddir", weather.getWind_dir() + "", "#B95EA3"));
                templateMessage.addData(new WxMpTemplateData("caihongpi", tianApiService.getCaiHongPi(), "#FF69B4"));
                templateMessage.addData(new WxMpTemplateData("en", ensentence.getEnWord() + "", "#C71585"));
                templateMessage.addData(new WxMpTemplateData("zh", ensentence.getZhWord() + "", "#C71585"));
                log.info(templateMessage.toJson());
                log.info(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
            }
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
        }
    }
}
