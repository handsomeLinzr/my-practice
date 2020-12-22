package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.v2.login.LoginForWechat;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:48 下午
 * @since V1.0.0
 */
public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean supports(Object adapter) {
        return adapter instanceof LoginForWechat;
    }

    @Override
    public ResultMsg login(String key, String value, Object login) {
        return ((LoginForWechat)login).login(key, value);
    }
}