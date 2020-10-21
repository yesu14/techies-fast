/**
 * Copyright (c) 2020 Techies-RG All rights reserved.
 *
 * 版权所有，侵权必究！
 */

package io.techies.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author Techies-RG
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
