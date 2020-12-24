package com.example.pattern.decorator.passport.v2.strategy;

import com.example.pattern.decorator.passport.v1.Member;
import com.example.pattern.decorator.passport.v1.ResultMsg;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 5:15 下午
 * @since V1.0.0
 */
public class WechatLogin implements Login {
    @Override
    public ResultMsg login(String key, String value) {
        return new ResultMsg(200, "wechat登录成功", new Member());
    }
}
