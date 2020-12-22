package com.example.pattern.adapter.login.v2;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.SiginService;
import com.example.pattern.adapter.login.v2.IPassportForThirdService;
import com.example.pattern.adapter.login.v2.adapters.*;
import com.example.pattern.adapter.login.v2.login.*;

/**
 * Description: 第三方登录端口适配器
 * (继承旧登录服务可以兼容旧的登录，实现新的登录标准即可开发实现新的拓展)
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:41 下午
 * @since V1.0.0
 */
public class PassportForThirdServiceAdapter extends SiginService implements IPassportForThirdService {
    @Override
    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, null, LoginForQQAdapter.class, LoginForQQ.class);
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId, null, LoginForWechatAdapter.class, LoginForWechat.class);
    }

    @Override
    public ResultMsg loginForTel(String phone, String code) {
        return processLogin(phone, code, LoginForTelAdapter.class, LoginForTel.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token, null, LoginForTokenAdapter.class, LoginForToken.class);
    }

    @Override
    public ResultMsg loginForRegister(String username, String password) {
        return processLogin(username, password, LoginForRegisterAdapter.class, LoginForRegister.class);
    }

    @Override
    public ResultMsg loginForSina(String openId) {
        return processLogin(openId, null, LoginForSinaAdapter.class, LoginForSina.class);
    }

    // 登录
    private ResultMsg processLogin(String key, String token, Class<? extends LoginAdapter> adapterClass, Class<? extends Login> loginClass) {
        try {
            LoginAdapter loginAdapter = adapterClass.newInstance();
            Login login = loginClass.newInstance();
            if (loginAdapter.supports(login)) {
                return loginAdapter.login(key, token, login);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
