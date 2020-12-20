package com.example.pattern.adapter;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.ThirdSiginService;
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
    }

}
