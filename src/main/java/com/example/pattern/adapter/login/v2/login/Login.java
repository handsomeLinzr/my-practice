package com.example.pattern.adapter.login.v2.login;

import com.example.pattern.adapter.login.ResultMsg;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 2:31 下午
 * @since V1.0.0
 */
public interface Login {

    /**
     * 登录
     * @param key
     * @param token
     * @return
     */
    ResultMsg login(String key, String token);

}
