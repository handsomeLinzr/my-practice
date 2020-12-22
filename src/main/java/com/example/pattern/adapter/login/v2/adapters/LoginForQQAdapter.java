package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.v2.login.LoginForQQ;

/**
 * Description: QQ登录适配器
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:47 下午
 * @since V1.0.0
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean supports(Object login) {
        return login instanceof LoginForQQ;
    }

    @Override
    public ResultMsg login(String key, String token, Object login) {
        return ((LoginForQQ)login).login(key, token);
    }
}
