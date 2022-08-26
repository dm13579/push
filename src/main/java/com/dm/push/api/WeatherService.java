package com.dm.push.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dm.push.entity.Weather;
import com.dm.push.properties.WeatherProperties;
import com.dm.push.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 气象服务
 *
 * @author dm
 * @date 2022/08/26
 */
@Service
@RequiredArgsConstructor
public class WeatherService {

    private final HttpUtils httpUtils;
    private final WeatherProperties weatherProperties;

    public Weather getWeather() {
        Map<String, Object> paramMap = new HashMap<>(32);
        paramMap.put("district_id", weatherProperties.getDistrictId());
        paramMap.put("data_type", weatherProperties.getDataType());
        paramMap.put("ak", weatherProperties.getAk());
        String result = httpUtils.getResponseResult(weatherProperties.getUrl(), paramMap);

        JSONObject json = JSONObject.parseObject(result);
        JSONArray forecasts = json.getJSONObject("result").getJSONArray("forecasts");
        // 一周内天气
        List<Weather> weathers = forecasts.toJavaList(Weather.class);
        // 获取当天
        Weather weather = weathers.get(0);

        // 现在状态设入
        JSONObject now = json.getJSONObject("result").getJSONObject("now");
        weather.setText(now.getString("text"));
        weather.setTemp(now.getString("temp"));
        weather.setWind_class(now.getString("wind_class"));
        weather.setWind_dir(now.getString("wind_dir"));
        return weather;
    }
}
