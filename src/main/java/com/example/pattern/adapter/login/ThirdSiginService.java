package com.example.pattern.adapter.login;

/**
 * 新的登录服务，继续原来的登录服务，直接调用即可
 * @author LZR
 * @date 2020/12/20-22:41
 */
public class ThirdSiginService extends SiginService {

    // QQ登录，先注册后登录
    public ResultMsg loginForQQ(String openId) {
        return registForQQ(openId);
    }

    // token登录
    public ResultMsg loginForToken(String token) {
        return null;
    }

    // 微信登录
    public ResultMsg loginForWetchat(String wid) {
        return null;
    }

    // QQ注册
    public ResultMsg registForQQ(String username) {
        ResultMsg regist = super.regist(username, null);
        return super.login(regist.getUser().getUsername(), regist.getUser().getPassword());
    }

}
