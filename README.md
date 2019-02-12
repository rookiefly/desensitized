# desensitized —— 基于自定义注解实现日志字段脱敏



### 项目说明

目前项目核心代码只有3个包：annotation、enums、utils

```
com.rookiefly.log.desensitized
                          .annotation
                                     .Desensitized
                          .enums
                                .SensitiveTypeEnum
                          .utils
                                .DesensitizedUtils
```

1、Desensitized是标记敏感信息的注解，用于标记在需要脱敏的字段上，用法建test下的com.rookiefly.log.desensitized.entity.BaseUserInfo类

2、SensitiveTypeEnum是脱敏的字段类型枚举，包括手机号、身份证号、姓名等

3、DesensitizedUtils对字段脱敏的核心逻辑

### 使用方法：

详见test包下的com.rookiefly.log.desensitized.utils.DesensitizedUtilsTest类

### 博客链接：
数据脱敏——什么是数据脱敏：http://blog.csdn.net/huyuyang6688/article/details/77689459

数据脱敏——基于自定义注解实现日志脱敏 http://blog.csdn.net/huyuyang6688/article/details/77759844