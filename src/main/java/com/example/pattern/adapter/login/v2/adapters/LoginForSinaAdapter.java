package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.v2.login.LoginForSina;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 4:09 下午
 * @since V1.0.0
 */
public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean supports(Object login) {
        return login instanceof LoginForSina;
    }

    @Override
    public ResultMsg login(String key, String token, Object login) {
        return ((LoginForSina)login).login(key, token);
    }
}
