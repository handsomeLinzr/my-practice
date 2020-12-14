package com.example.pattern.proxy.dbroute.proxy;

import com.example.pattern.proxy.dbroute.db.DynamicRouteSourceEntity;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.LocalDate;

/**
 * Description: 动态路由的cglib动态代理拦截器
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 12:34 下午
 * @since V1.0.0
 */
public class DynamicRouteSourceMethodInterceptor implements MethodInterceptor {

    // 创建代理
    public Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("使用cglib动态代理");
        before(args[0]);
        Object result = proxy.invokeSuper(obj, args);
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
