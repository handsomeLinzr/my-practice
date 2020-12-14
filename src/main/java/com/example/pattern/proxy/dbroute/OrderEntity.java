package com.example.pattern.proxy.dbroute;

import java.time.LocalDate;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 9:53 上午
 * @since V1.0.0
 */
public class OrderEntity {
    private Object orderInfo;
    private LocalDate createTime;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
}
