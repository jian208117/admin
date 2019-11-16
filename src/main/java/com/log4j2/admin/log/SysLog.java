package com.log4j2.admin.log;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author jian
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
