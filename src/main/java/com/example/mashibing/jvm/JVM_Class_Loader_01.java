package com.example.mashibing.jvm;

import sun.security.ec.SunEC;

/**
 * Description:
 *
 * @author Linzherong
 * @date 2022/3/26 9:56 下午
 */
public class JVM_Class_Loader_01 {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());   //------Bootstrap(null)
        System.out.println(SunEC.class.getClassLoader());  // --------AppClassLoader
        System.out.println(JVM_Class_Loader_01.class.getClassLoader());  // --------AppClassLoader
        System.out.println(JVM_Class_Loader_01.class.getClassLoader().getClass().getClassLoader());  // null
    }

}
