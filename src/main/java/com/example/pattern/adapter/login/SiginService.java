package com.example.pattern.adapter.login;

/**
 * 老系统服务
 * @author LZR
 * @date 2020/12/20-22:37
 */
public class SiginService {
    // 注册
    public ResultMsg regist(String name, String password) {
        return new ResultMsg(200, "注册成功", new User());
    }

    // 登录
    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "登录成功", new User());
    }
}
