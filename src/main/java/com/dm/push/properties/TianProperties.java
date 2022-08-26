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
@ConfigurationProperties("dm.tian")
@Component
@Data
public class TianProperties {

    /**
     * appKey
     */
    private String key;

    /**
     * 彩虹屁接口
     *
     * @see <a href="https://www.tianapi.com/apiview/181">彩虹屁接口文档</a>
     */
    private String caihongpi;

    /**
     * 英语一句话接口
     *
     * @see <a href="https://www.tianapi.com/apiview/62">英语一句话接口文档</a>
     */
    private String ensentence;


}
