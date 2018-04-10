package com.qudian.pay.ares.dao.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportAnnotation {
	//列名
	String name() default "";

	//宽度
	int width() default 20;

	//忽略该字段
	boolean skip() default false;
}
