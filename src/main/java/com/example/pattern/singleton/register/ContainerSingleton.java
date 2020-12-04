package com.example.pattern.singleton.register;

import com.example.pattern.singleton.utils.ConcurrentExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/4 4:39 下午
 * @since V1.0.0
 */
public class ContainerSingleton {
    private ContainerSingleton() {}

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String name) {
        synchronized (ioc) {
            if (!ioc.containsKey(name)) {
                try {
                    Object bean = Class.forName(name).newInstance();
                    ioc.put(name, bean);
                    return bean;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return ioc.get(name);
        }
    }

}
