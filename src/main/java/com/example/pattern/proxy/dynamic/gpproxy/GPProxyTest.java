package com.example.pattern.proxy.dynamic.gpproxy;

import com.example.pattern.proxy.dynamic.jdkproxy.Person;
import com.example.pattern.proxy.dynamic.jdkproxy.Son;

/**
 * Created by Tom on 2019/3/10.
 */
public class GPProxyTest {

    public static void main(String[] args) {
        try {

            //JDK动态代理的实现原理
            Person obj = (Person) new GPMeipo().getInstance(new Son());
            System.out.println(obj.getClass());
            obj.findLove();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
