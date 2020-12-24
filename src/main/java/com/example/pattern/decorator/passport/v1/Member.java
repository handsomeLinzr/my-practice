package com.example.pattern.decorator.passport.v1;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:50 下午
 * @since V1.0.0
 */
public class Member {

    private String username;
    private String password;
    private String addr;

    public Member() {}

    public Member(String username, String password, String addr) {
        this.username = username;
        this.password = password;
        this.addr = addr;
    }
}
