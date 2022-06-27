package com.fileIO.shj;

import com.fileIO.shj.annotation.FileAnnotation;

public class MyService {
    @FileAnnotation
    public void method1() {
        System.out.println("실행내용1");
    }

    @FileAnnotation("*")
    public void method2() {
        System.out.println("실행내용2");
    }

    @FileAnnotation(value = "*", number = 20)
    public void method3() {
        System.out.println("실행내용3");
    }
}