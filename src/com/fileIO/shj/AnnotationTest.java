package com.fileIO.shj;

import com.fileIO.shj.Controller;
import com.fileIO.shj.Mapping;

@Controller
public class AnnotationTest {
    
    @Mapping(url="/",method="get")
    public void annotationPrint(){
        System.out.println("프린트");
    }
}
