package com.example.pattern.delegate.simple;

/**
 * Description: 老板 让经理工作
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/15 3:52 下午
 * @since V1.0.0
 */
public class Boss {

    public void work(String command, Leader leader) {
        leader.doing(command);
    }
}
