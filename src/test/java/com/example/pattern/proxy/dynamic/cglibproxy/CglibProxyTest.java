package com.example.pattern.proxy.dynamic.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.jupiter.api.Test;
import sun.misc.ProxyGenerator;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/13 10:43 下午
 * @since V1.0.0
 */
public class CglibProxyTest {

    @Test
    public void test() {
        // 先设置才会生效
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/lzr/cglib_code");

        MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        People proxy = (People) myMethodInterceptor.getProxy(People.class);
        proxy.marryWife();
        proxy.buyHouse();
    }

}
