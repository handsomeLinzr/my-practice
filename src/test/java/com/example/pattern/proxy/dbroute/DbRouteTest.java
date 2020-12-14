package com.example.pattern.proxy.dbroute;

import com.example.pattern.proxy.dbroute.proxy.DynamicRouteSourceJdkDynamicInvocationHandler;
import com.example.pattern.proxy.dbroute.proxy.DynamicRouteSourceMethodInterceptor;
import com.example.pattern.proxy.dbroute.proxy.DynamicRouteSourceStaticProxy;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.asm.ImmediateOrRegister;

import java.time.LocalDate;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 9:59 上午
 * @since V1.0.0
 */
public class DbRouteTest {

    // 普通方式
    @Test
    public void test1() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreateTime(LocalDate.now());
//        orderEntity.setCreateTime(LocalDate.of(2018, 3, 20));
        System.out.printf("切换DB数据源到 DB_%s下%n", orderEntity.getCreateTime().getYear());
        IOrderService orderService = new OrderServiceImpl();
        orderService.createOrder(orderEntity);
        System.out.println("切换回默认数据源 default 下");
    }

    // 静态代理
    @Test
    public void test2() {
        OrderEntity order = new OrderEntity();
        order.setCreateTime(LocalDate.of(2021, 3, 20));
        IOrderService orderService = new OrderServiceImpl();
        DynamicRouteSourceStaticProxy dynamicRouteSourceStaticProxy = new DynamicRouteSourceStaticProxy(orderService);
        dynamicRouteSourceStaticProxy.createOrder(order);
    }

    // jdk动态代理
    @Test
    public void test3() {
        OrderEntity order = new OrderEntity();
        order.setCreateTime(LocalDate.of(2025, 3, 20));

        DynamicRouteSourceJdkDynamicInvocationHandler handler = new DynamicRouteSourceJdkDynamicInvocationHandler();
        IOrderService orderService = (IOrderService) handler.getProxy(new OrderServiceImpl());
        orderService.createOrder(order);
    }

    // cglib动态代理
    @Test
    public void test4() {
        OrderEntity order = new OrderEntity();
        order.setCreateTime(LocalDate.of(2026, 3, 20));
        DynamicRouteSourceMethodInterceptor methodInterceptor = new DynamicRouteSourceMethodInterceptor();
        IOrderService orderService = (OrderServiceImpl) methodInterceptor.getProxy(OrderServiceImpl.class);
        orderService.createOrder(order);
    }

}
