package com.example.pattern.proxy.dbroute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 9:57 上午
 * @since V1.0.0
 */
public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        System.out.println("orderService 创建订单......");
        return orderDao.createOrder(order);
    }
}
