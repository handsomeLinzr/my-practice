package com.example.pattern.decorator.passport.v2;

import com.example.pattern.decorator.passport.v2.strategy.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 5:22 下午
 * @since V1.0.0
 */
public class LoginFactory {

    public static final String LOGIN_FOR_QQ = "QQ";
    public static final String LOGIN_FOR_REGISTER = "register";
    public static final String LOGIN_FOR_TELPHONE = "telphone";
    public static final String LOGIN_FOR_TOKEN = "token";
    public static final String LOGIN_FOR_WECHAT = "wechat";
    public static final String DEFAULT = LOGIN_FOR_QQ;

    private static final Map<String, Login> MAP = new ConcurrentHashMap<>(5);
    static {
        MAP.put(LOGIN_FOR_QQ, new QQLogin());
        MAP.put(LOGIN_FOR_REGISTER, new RegisterLogin());
        MAP.put(LOGIN_FOR_TELPHONE, new TelphoneLogin());
        MAP.put(LOGIN_FOR_TOKEN, new TokenLogin());
        MAP.put(LOGIN_FOR_WECHAT, new WechatLogin());
    }

    public static Login getLogin(String type) {
        if (MAP.containsKey(type)) {
            return MAP.get(type);
        }
        return MAP.get(DEFAULT);
    }

}
