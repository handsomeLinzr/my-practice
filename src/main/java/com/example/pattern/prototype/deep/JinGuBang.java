package com.example.pattern.prototype.deep;

import java.io.Serializable;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 11:55 上午
 * @since V1.0.0
 */
public class JinGuBang implements Cloneable, Serializable {
    private float h;
    private float w;

    public float getH() {
        return h;
    }

    public void setH(float h) {
        this.h = h;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void big() {
        h *= 2;
        w *= 2;
    }

    public void small() {
        h /= 2;
        w /= 2;
    }
}
