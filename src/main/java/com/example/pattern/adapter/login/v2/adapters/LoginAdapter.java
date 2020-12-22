package com.example.pattern.adapter.login.v2.adapters;

import com.example.pattern.adapter.login.ResultMsg;

/**
 * Description: 登录适配器
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:43 下午
 * @since V1.0.0
 */
public interface LoginAdapter {

    /**
     * 是否支持适配
     * @param login
     * @return
     */
    boolean supports(Object login);

    /**
     * 登录业务
     * @param key
     * @param token
     * @return
     */
    ResultMsg login(String key, String token, Object login);

}
