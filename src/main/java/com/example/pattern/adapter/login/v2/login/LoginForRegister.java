package com.example.pattern.adapter.login.v2.login;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.User;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 3:14 下午
 * @since V1.0.0
 */
public class LoginForRegister implements Login {
    @Override
    public ResultMsg login(String key, String token) {
        return new ResultMsg(200, "注册登录成功", new User());
    }
}
