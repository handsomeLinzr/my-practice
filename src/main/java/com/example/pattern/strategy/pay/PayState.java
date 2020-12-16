package com.example.pattern.strategy.pay;

/**
 * 支付结果
 * @author LZR
 * @date 2020/12/16-23:56
 */
public class PayState {
    private int code;
    private String msg;
    private Object data;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{code:" + code +";msg:" + msg + ";data:" + data + "}";
    }
}
