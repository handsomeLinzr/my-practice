package com.example.pattern.proxy.dbroute.proxy;

import com.example.pattern.proxy.dbroute.db.DynamicRouteSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDate;

/**
 * Description: JDK动态代理动态路由数据源
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 11:51 上午
 * @since V1.0.0
 */
public class DynamicRouteSourceJdkDynamicInvocationHandler implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用jdk动态代理");
        before(args[0]);
        Object result = method.invoke(this.target, args);
        after();
        return result;
    }

    private void before(Object target) {
        try {
            Method method = target.getClass().getMethod("getCreateTime", null);
            LocalDate createDate = (LocalDate) method.invoke(target);
            DynamicRouteSourceEntity.setRouteSource(createDate.getYear());
            System.out.printf("当前数据源——> %s%n", DynamicRouteSourceEntity.getRouteSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void after() {
        DynamicRouteSourceEntity.resetRouteSource();
        System.out.printf("当前数据源 ——> %s%n", DynamicRouteSourceEntity.getRouteSource());
    }

}
