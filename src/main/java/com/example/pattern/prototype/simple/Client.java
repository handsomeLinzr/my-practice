package com.example.pattern.prototype.simple;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 10:12 上午
 * @since V1.0.0
 */
public class Client {
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype startClone() {
        return prototype.clone();
    }
}
