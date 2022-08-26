package com.dm.push.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 天行属性
 *
 * @author dm
 * @date 2022/08/26
 */
@ConfigurationProperties("dm.weather")
@Component
@Data
public class WeatherProperties {

    /**
     * url
     */
    private String url;

    /**
     * 行政代码
     */
    private String districtId;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     *
     */
    private String ak;
}
