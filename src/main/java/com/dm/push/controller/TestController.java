package com.dm.push.controller;

import com.dm.push.api.TianApiService;
import com.dm.push.api.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试控制器
 *
 * @author dm
 * @date 2022/08/26
 */
@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final TianApiService tianApiService;
    private final WeatherService weatherService;

    @GetMapping("/getCaiHongPi")
    public void getCaiHongPi() {
        System.out.println(tianApiService.getCaiHongPi());
    }

    @GetMapping("/getEnsentence")
    public void getEnsentence() {
        System.out.println(tianApiService.getEnsentence());
    }

    @GetMapping("/getWeather")
    public void getWeather() {
        System.out.println(weatherService.getWeather());
    }
}
