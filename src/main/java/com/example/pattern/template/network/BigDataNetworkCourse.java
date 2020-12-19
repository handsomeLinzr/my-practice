package com.example.pattern.template.network;

/**
 * @author LZR
 * @date 2020/12/19-14:57
 */
public class BigDataNetworkCourse extends NetworkCourse {

    private boolean needNetwork;

    public BigDataNetworkCourse(boolean needNetwork) {
        this.needNetwork = needNetwork;
    }

    @Override
    protected boolean needHomework() {
        return this.needNetwork;
    }

    @Override
    void checkHomework() {
        System.out.println("检查大数据课程作业");
    }
}
