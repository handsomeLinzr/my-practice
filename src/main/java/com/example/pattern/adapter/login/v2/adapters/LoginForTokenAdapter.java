package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.v2.login.LoginForToken;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:49 下午
 * @since V1.0.0
 */
public class LoginForTokenAdapter implements LoginAdapter {
    @Override
    public boolean supports(Object adapter) {
        return adapter instanceof LoginForToken;
    }

    @Override
    public ResultMsg login(String key, String value, Object login) {
        return ((LoginForToken)login).login(key, value);
    }
}
