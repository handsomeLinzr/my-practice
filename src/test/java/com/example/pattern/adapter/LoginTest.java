package com.example.pattern.adapter;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.SiginService;
import com.example.pattern.adapter.login.v1.ThirdSiginService;
import com.example.pattern.adapter.login.v2.PassportForThirdServiceAdapter;
import org.junit.jupiter.api.Test;

/**
 * @author LZR
 * @date 2020/12/20-22:52
 */
public class LoginTest {

    @Test
    public void test1() {
        ThirdSiginService thirdSiginService = new ThirdSiginService();
        ResultMsg result = thirdSiginService.regist("TOM", "123");
        System.out.println(result);

        ResultMsg resultMsg = thirdSiginService.loginForQQ("123545");
        System.out.println(resultMsg);

    }

    @Test
    public void test2() {
        PassportForThirdServiceAdapter passport = new PassportForThirdServiceAdapter();
        System.out.println(passport.loginForWechat("123123"));
        System.out.println(passport.loginForTel("12334", "123453"));
        System.out.println(passport.loginForSina("234254"));
    }

}
