package com.example.pattern.decorator.passport.v2.strategy;

import com.example.pattern.decorator.passport.v1.ResultMsg;

/**
 * Description: 登录的接口
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 5:13 下午
 * @since V1.0.0
 */
public interface Login {
    ResultMsg login(String key, String value);
}
