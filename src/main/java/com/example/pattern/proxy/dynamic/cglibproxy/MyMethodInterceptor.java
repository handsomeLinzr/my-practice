package com.example.pattern.proxy.dynamic.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/13 10:21 下午
 * @since V1.0.0
 */
public class MyMethodInterceptor implements MethodInterceptor {

    public Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /*
     * o 被Enhancer创建出来的代理对象； method 目标方法  objects：参数  methodProxy：代理方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-------" + o.getClass());
        System.out.println("-------" + method);
        System.out.println("cglib proxy before");
        methodProxy.invokeSuper(o, objects);
        System.out.println("cglib proxy after");
        return null;
    }
}
