package com.dm.push.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dm.push.entity.TianEnsentenceEntity;
import com.dm.push.properties.TianProperties;
import com.dm.push.utils.HttpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 天行api服务
 *
 * @author dm
 * @date 2022/08/26
 * @see <a href="https://www.tianapi.com/console/">天行API</a>
 */
@Service
@RequiredArgsConstructor
public class TianApiService {

    private final HttpUtils httpUtils;
    private final TianProperties tianProperties;

    /**
     * 得到参数映射 基本参数预设
     *
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    private Map<String, Object> getParamMap() {
        Map<String, Object> paramMap = new HashMap<>(32);
        paramMap.put("key", tianProperties.getKey());
        return paramMap;
    }

    /**
     * 获取每日彩虹屁
     *
     * @return {@link String}
     */
    public String getCaiHongPi() {
        String result = httpUtils.getResponseResult(tianProperties.getCaihongpi(), getParamMap());

        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray list = jsonObject.getJSONArray("newslist");
        return list.getJSONObject(0).getString("content");
    }

    /**
     * 获取英语一句话
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    public TianEnsentenceEntity getEnsentence() {
        String result = httpUtils.getResponseResult(tianProperties.getEnsentence(), getParamMap());

        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray list = jsonObject.getJSONArray("newslist");
        String enWord = list.getJSONObject(0).getString("en");
        String zhWord = list.getJSONObject(0).getString("zh");
        return TianEnsentenceEntity.builder()
                .enWord(enWord)
                .zhWord(zhWord)
                .build();
    }
}
