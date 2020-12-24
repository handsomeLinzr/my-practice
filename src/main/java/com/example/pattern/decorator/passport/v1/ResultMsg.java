package com.example.pattern.decorator.passport.v1;

/**
 * Description: 请求返回数据
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/24 3:49 下午
 * @since V1.0.0
 */
public class ResultMsg {

    private int code;
    private String msg;
    private Member member;

    public ResultMsg() {}

    public ResultMsg(int code, String msg, Member member) {
        this.code = code;
        this.msg = msg;
        this.member = member;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", member=" + member +
                '}';
    }
}
