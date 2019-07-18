package com.example.lib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MyClass {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/apple/a.txt");
//      先判断文件目录是否存在，不存在则创建
//        if (!file.exists()) {
//          boolean result=  file.getParentFile().mkdirs();
//          System.out.println(result);
//        }else {
//            System.out.println("file exists");
//        }
//      创建文件  /Users/apple
//        file.createNewFile();
        System.out.println(file.createNewFile());
        OutputStreamWriter outputStream=new OutputStreamWriter(new FileOutputStream(file,true));
        outputStream.write("\n");
        outputStream.write("2你哈哈！");
        outputStream.close();
    }
}
