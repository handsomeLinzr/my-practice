package com.example.pattern.proxy.dbroute;


/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 9:54 上午
 * @since V1.0.0
 */
public class OrderDao {
    public OrderEntity createOrder(OrderEntity order) {
        System.out.println("orderDao创建订单......" + order.getCreateTime());
        return order;
    }
}
