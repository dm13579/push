package com.dm.push.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 英语一句话实体
 *
 * @author dm
 * @date 2022/08/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TianEnsentenceEntity implements Serializable {

    /**
     * 序列化版本编号
     */
    private static final long serialVersionUID = 4627123619296722443L;

    /**
     * 英语
     */
    public String enWord;

    /**
     * 汉语
     */
    public String zhWord;
}
