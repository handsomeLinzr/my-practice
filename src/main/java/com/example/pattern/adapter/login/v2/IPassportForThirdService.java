package com.example.pattern.adapter.login.v2;

import com.example.pattern.adapter.login.ResultMsg;

/**
 * Description: 第三方登录拓展接口
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/22 1:36 下午
 * @since V1.0.0
 */
public interface IPassportForThirdService {

    /**
     * QQ登录
     * @param openId
     * @return
     */
    ResultMsg loginForQQ(String openId);

    /**
     * 微信登录
     * @param openId
     * @return
     */
    ResultMsg loginForWechat(String openId);

    /**
     * 手机登录
     * @param phone
     * @param code
     * @return
     */
    ResultMsg loginForTel(String phone, String code);

    /**
     * token登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 注册登录
     * @param username
     * @param password
     * @return
     */
    ResultMsg loginForRegister(String username, String password);

    /**
     * 新浪登录
     * @param openId
     * @return
     */
    ResultMsg loginForSina(String openId);

}
