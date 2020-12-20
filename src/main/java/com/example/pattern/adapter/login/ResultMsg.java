package com.example.pattern.adapter.login;

/**
 * @author LZR
 * @date 2020/12/20-22:36
 */
public class ResultMsg {
    private int code;
    private String msg;
    private User user;

    public ResultMsg(int code, String msg, User user) {
        this.code = code;
        this.msg = msg;
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", user=" + user +
                '}';
    }
}
