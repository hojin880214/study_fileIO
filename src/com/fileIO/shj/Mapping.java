package com.fileIO.shj;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Mapping {
    String url() default "/";
    String method() default "get";
}
