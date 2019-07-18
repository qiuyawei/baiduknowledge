package com.example.firstapple;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tst {
    @Test
    public void doCaclute(){
//        float a=100.001f;ØØ

//        double d=100.0010;
//        byte a=1,b=2;
//        System.out.println(Byte.MAX_VALUE);//科学计数法
//        System.out.println(Byte.MIN_VALUE);
//        System.out.println(a+b);
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//       /*/**/*/ System.out.println(sdf.format(new Date()));
//        Calendar calendar=Calendar.getInstance();
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH));
//        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//        String name="baiDu";
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append(name);
//        System.out.println(name.concat("_qiu"));
//        System.out.println(stringBuilder.toString());
        char c=1;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            try {
                c = (char) br.read();
                System.out.println(c);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (c != 'q');

    }
}
