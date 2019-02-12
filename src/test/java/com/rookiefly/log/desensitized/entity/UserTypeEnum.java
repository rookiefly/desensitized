package com.rookiefly.log.desensitized.entity;

import java.util.HashMap;
import java.util.Map;

public enum UserTypeEnum {

    UKNOWN(0, "未知"),
    GENERAL(1, "一般用户"),
    OPERATOR(2, "操作员"),
    ADMINISTRATOR(3, "管理员"),
    ;

    private static Map<Integer, UserTypeEnum> valueMap = new HashMap();
    private Integer code;
    private String description;

    UserTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public UserTypeEnum setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserTypeEnum setDescription(String description) {
        this.description = description;
        return this;
    }

    public static UserTypeEnum getEnumByCode(String code) {
        if (valueMap.isEmpty()) {
            UserTypeEnum[] userTypeEnums = UserTypeEnum.values();
            for (UserTypeEnum userTypeEnum : userTypeEnums) {
                valueMap.put(userTypeEnum.getCode(), userTypeEnum);
            }
        }
        return valueMap.get(code) == null ? UserTypeEnum.UKNOWN : valueMap.get(code);
    }
}
