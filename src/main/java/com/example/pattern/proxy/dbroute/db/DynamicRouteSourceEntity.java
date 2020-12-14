package com.example.pattern.proxy.dbroute.db;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Description: 动态路由实体
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/14 10:03 上午
 * @since V1.0.0
 */
public class DynamicRouteSourceEntity {

    private static final String DEFAULT_ROUTE_SOURCE = "default";
    private static final ThreadLocal<String> THREAD_LOCAL = ThreadLocal.withInitial(() -> DEFAULT_ROUTE_SOURCE);

    // 获取数据源
    public static String getRouteSource() {
        return THREAD_LOCAL.get();
    }

    // 设置数据源
    public static void setRouteSource(String dbRouter) {
        System.out.printf("切换DB数据源到 DB_%s下%n", dbRouter);
        THREAD_LOCAL.set(dbRouter);
    }

    public static void setRouteSource(int dbRouter) {
        System.out.printf("切换DB数据源到 DB_%s下%n", dbRouter);
        THREAD_LOCAL.set(String.valueOf(dbRouter));
    }

    // 重置数据源
    public static void resetRouteSource() {
        THREAD_LOCAL.set(DEFAULT_ROUTE_SOURCE);
        System.out.printf("切换回默认数据源 %s下%n", THREAD_LOCAL.get());
    }

}
