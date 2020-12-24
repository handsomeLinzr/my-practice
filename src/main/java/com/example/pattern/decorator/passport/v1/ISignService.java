package com.example.pattern.decorator.passport.v1;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 4:13 下午
 * @since V1.0.0
 */
public interface ISignService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
     ResultMsg register(String username, String password);

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
     ResultMsg login(String username, String password);

}
