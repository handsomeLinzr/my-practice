package com.example.pattern.decorator.passport.v2;

import com.example.pattern.decorator.passport.v1.ISignService;
import com.example.pattern.decorator.passport.v1.ResultMsg;

/**
 * Description: 第三方扩展登录接口
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 5:02 下午
 * @since V1.0.0
 */
public interface IThirdSignService extends ISignService {

    /**
     * QQ登录
     * @param id
     * @return
     */
    ResultMsg loginForQQ(String id);

    /**
     * 微信登录
     * @param id
     * @return
     */
    ResultMsg loginForWechat(String id);

    /**
     * 记住登录状态后自动登录
     * @param token
     * @return
     */
    ResultMsg loginForToken(String token);

    /**
     * 手机号登录
     * @param telphone
     * @param code
     * @return
     */
    ResultMsg loginForTelphone(String telphone, String code);

    /**
     * 注册后自动登录
     * @param username
     * @param passport
     * @return
     */
    ResultMsg loginForRegist(String username, String passport);

}
