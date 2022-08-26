package com.dm.push.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * wx属性
 *
 * @author dm
 * @date 2022/08/26
 */
@ConfigurationProperties("dm.wx")
@Component
@Data
public class WxProperties {

    private String appId;

    private String secret;

}
