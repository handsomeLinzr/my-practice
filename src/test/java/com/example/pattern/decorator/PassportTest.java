package com.example.pattern.decorator;

import com.example.pattern.decorator.passport.v1.ISignService;
import com.example.pattern.decorator.passport.v1.SignService;
import com.example.pattern.decorator.passport.v2.IThirdSignService;
import com.example.pattern.decorator.passport.v2.ThirdSignService;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 4:50 下午
 * @since V1.0.0
 */
public class PassportTest {

    @Test
    public void testV1() {
        ISignService signService = new SignService();
        System.out.println(signService.register("123", "123"));
        System.out.println(signService.login("123", "123"));
    }

    @Test
    public void testV2() {
        IThirdSignService thirdSignService = new ThirdSignService(new SignService());
        System.out.println(thirdSignService.login("123", "123"));
        System.out.println(thirdSignService.loginForQQ("123"));
        System.out.println(thirdSignService.loginForWechat("54364"));
        System.out.println(thirdSignService.loginForRegist("123", "54336"));
    }

}
