package com.example.pattern.delegate.mvc.controller;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 4:47 下午
 * @since V1.0.0
 */
public class OrderController {
    public String getOrderById(String id) {
        return "order info " + id;
    }
}
