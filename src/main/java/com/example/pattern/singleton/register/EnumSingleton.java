package com.example.pattern.singleton.register;

/**
 * Description: 枚举式单例模式
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 2:54 下午
 * @since V1.0.0
 */
public enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;

    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
