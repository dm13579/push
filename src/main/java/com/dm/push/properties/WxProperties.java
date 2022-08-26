package com.dm.push.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

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

    /**
     * 公众号应用程序编号
     *
     * @see <a href="http://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index">公众号测试平台</a>
     */
    private String appId;

    /**
     * 公众号秘密
     */
    private String secret;

    /**
     * 模板编号
     */
    private String templateId;

    /**
     * 发送对象
     */
    private List<String> userIds;
}
