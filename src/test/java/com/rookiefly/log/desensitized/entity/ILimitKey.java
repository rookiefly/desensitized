package com.rookiefly.log.desensitized.entity;

import java.util.concurrent.TimeUnit;

/**
 * @Title: ILimitKey
 * @Description: 限制key的接口<br>
 */
public interface ILimitKey {

    /**
     * 时间值
     *
     * @return
     */
    long getTimes();

    /**
     * 时间单位
     *
     * @return
     */
    TimeUnit getTimeUnit();

    /**
     * 限制值
     *
     * @return
     */
    long getLimitValue();

    /**
     * 限制key
     *
     * @param objects
     * @return
     */
    String getLimitFrequencyKey(Object... objects);
}
