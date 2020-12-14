package com.example.pattern.proxy.dbroute.proxy;

import com.example.pattern.proxy.dbroute.IOrderService;
import com.example.pattern.proxy.dbroute.OrderEntity;
import com.example.pattern.proxy.dbroute.db.DynamicRouteSourceEntity;

/**
 * Description: 动态数据源路由的静态代理
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 10:33 上午
 * @since V1.0.0
 */
public class DynamicRouteSourceStaticProxy implements IOrderService {

    private IOrderService orderService;

    public DynamicRouteSourceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        System.out.println("进入静态代理模式");
        DynamicRouteSourceEntity.setRouteSource(order.getCreateTime().getYear());
        OrderEntity result = orderService.createOrder(order);
        DynamicRouteSourceEntity.resetRouteSource();
        return result;
    }

}
