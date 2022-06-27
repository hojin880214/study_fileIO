package com.fileIO.shj.file;

import com.fileIO.shj.annotation.FileAnnotation;

public class FileService {

    @FileAnnotation("*")
    public void makeFile(){
        System.out.println("makeFile");
    }
}
