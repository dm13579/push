package com.dm.push.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cVzhanshi
 * @create 2022-08-04 2215
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {
    private static final long serialVersionUID = -3287110622828709745L;

    /**
     * 日期，北京时区
     */
    private String date;
    /**
     * 星期，北京时区
     */
    private String week;

    /**
     * 最高温度 (℃)
     */
    private String high;
    /**
     * 最低温度 (℃)
     */
    private String low;


    /**
     * 白天风向
     */
    private String wd_day;
    /**
     * 晚上风向
     */
    private String wd_night;

    /**
     * 晚上风力
     */
    private String wc_night;
    /**
     * 白天风力
     */
    private String wc_day;

    /**
     * 晚上天气现象
     */
    private String text_night;
    /**
     * 白天天气现象
     */
    private String text_day;


    // ====================现在======================
    /**
     * 天气现象
     */
    private String text;
    /**
     * 温度（℃）
     */
    private String temp;
    /**
     * 风力等级
     */
    private String wind_class;
    /**
     * 风向描述
     */
    private String wind_dir;
}
