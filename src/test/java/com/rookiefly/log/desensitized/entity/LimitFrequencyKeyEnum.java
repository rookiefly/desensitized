package com.rookiefly.log.desensitized.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Title: LimitFrequencyKeyEnum
 * @Description: 限制频次key枚举定义<br>
 */
public enum LimitFrequencyKeyEnum implements ILimitKey {
    SMSCODE_MOBILE_DAY_LIMIT("smscode_mobile_{mobile}_#yyyyMMdd#", "手机号发送短信验证码每天不超过N次",
            "smscode_mobile_{}_#yyyyMMdd#", 1, TimeUnit.DAYS, 100),
    ;

    private String key;
    private String name;
    private String expression;
    private long times;
    private TimeUnit timeUnit;
    private long limitValue;

    LimitFrequencyKeyEnum(
            String key, String name, String expression,
            long times, TimeUnit timeUnit, long limitValue) {
        this.key = key;
        this.name = name;
        this.expression = expression;
        this.times = times;
        this.timeUnit = timeUnit;
        this.limitValue = limitValue;
    }

    public String getLimitFrequencyKey(Object... objects) {
        StringBuilder key = new StringBuilder();
        //加上limit_前缀
        key.append("limit_").append(getReplaceExpression());
//        return OwnStringUtils.getMessageFormat(key.toString(), objects);
        return "";
    }

    /**
     * 获取替换动态参数后的表达式
     *
     * @return
     */
    private String getReplaceExpression() {
        Map<String, String> parameterMap = defineDynamceParameterMap();
        String expression = this.expression;
        for (String key : parameterMap.keySet()) {
            expression = expression.replaceAll("#" + key + "#", parameterMap.get(key));
        }
        return expression;
    }

    /**
     * 定义动态参数值
     *
     * @return
     */
    private Map<String, String> defineDynamceParameterMap() {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("yyyyMMdd", "20170721");

        return parameterMap;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getExpression() {
        return expression;
    }

    public long getTimes() {
        return times;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public long getLimitValue() {
        return limitValue;
    }
}
