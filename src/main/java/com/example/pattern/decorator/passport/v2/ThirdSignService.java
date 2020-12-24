package com.example.pattern.decorator.passport.v2;

import com.example.pattern.decorator.passport.v1.ISignService;
import com.example.pattern.decorator.passport.v1.ResultMsg;

/**
 * Description: 第三方登录扩展（用装饰器模式）
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 5:04 下午
 * @since V1.0.0
 */
public class ThirdSignService implements IThirdSignService{

    private ISignService signService;

    public ThirdSignService(ISignService signService) {
        this.signService = signService;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return process(LoginFactory.LOGIN_FOR_QQ, id, null);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return process(LoginFactory.LOGIN_FOR_WECHAT, id, null);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return process(LoginFactory.LOGIN_FOR_TOKEN, token, null);
    }

    @Override
    public ResultMsg loginForTelphone(String telphone, String code) {
        return process(LoginFactory.LOGIN_FOR_TELPHONE, telphone, code);
    }

    @Override
    public ResultMsg loginForRegist(String username, String passport) {
        return process(LoginFactory.LOGIN_FOR_REGISTER, username, passport);
    }

    @Override
    public ResultMsg register(String username, String password) {
        return this.signService.register(username, password);
    }

    @Override
    public ResultMsg login(String username, String password) {
        return this.signService.login(username, password);
    }

    // 获得登录策略登录
    private ResultMsg process(String type, String key, String value) {
        return LoginFactory.getLogin(type).login(key, value);
    }

}
