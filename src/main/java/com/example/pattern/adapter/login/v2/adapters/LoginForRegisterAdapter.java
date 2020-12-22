package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.v2.login.LoginForRegister;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:50 下午
 * @since V1.0.0
 */
public class LoginForRegisterAdapter implements LoginAdapter {
    @Override
    public boolean supports(Object adapter) {
        return adapter instanceof LoginForRegister;
    }

    @Override
    public ResultMsg login(String key, String value, Object login) {
        return ((LoginForRegister)login).login(key, value);
    }
}
