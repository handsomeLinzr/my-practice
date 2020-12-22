package com.example.pattern.adapter.login.v2.login;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.User;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 2:33 下午
 * @since V1.0.0
 */
public class LoginForQQ implements Login{
    @Override
    public ResultMsg login(String key, String token) {
        return new ResultMsg(200, "QQ登录成功", new User());
    }
}
