package com.example.pattern.adapter.login.v1;

import com.example.pattern.adapter.login.ResultMsg;
import com.example.pattern.adapter.login.SiginService;

/**
 * 新的登录服务，继续原来的登录服务，直接调用即可
 * @author LZR
 * @date 2020/12/20-22:41
 */
public class ThirdSiginService extends SiginService {

    // QQ登录，先注册后登录
    public ResultMsg loginForQQ(String openId) {
        return loginForRegister(openId, null);
    }

    // token登录
    public ResultMsg loginForToken(String token) {
        return null;
    }

    // 微信登录
    public ResultMsg loginForWechat(String wid) {
        return null;
    }

    // 手机登录
    public ResultMsg loginForTel(String telPhone, String code) {
        return null;
    }

    // 注册登录
    public ResultMsg loginForRegister(String username, String password) {
        ResultMsg register = super.regist(username, password);
        return super.login(register.getUser().getUsername(), register.getUser().getPassword());
    }

}
