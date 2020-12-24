package com.example.pattern.decorator.passport.v1;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 4:48 下午
 * @since V1.0.0
 */
public class SignService implements ISignService {
    @Override
    public ResultMsg register(String username, String password) {
        return new ResultMsg(200, "注册成功", new Member());
    }

    @Override
    public ResultMsg login(String username, String password) {
        return new ResultMsg(200, "登录成功", new Member());
    }
}
