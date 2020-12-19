package com.example.pattern.template.network;

/**
 * 网上课程抽象类
 * @author LZR
 * @date 2020/12/19-14:35
 */
public abstract class NetworkCourse {

    // 先执行一套流程（上课流程），将变化情况用抽象定义，子类重写
    // 抽象方法即可修改流程明细
    public final void createCourse() {
        // 1.发布预习资料
        this.postPreResource();
        // 2.制作课件PPT
        this.createPPT();
        // 3.在线直播
        this.liveVideo();
        // 4.提交课堂笔记
        this.postNote();
        // 5.提交源码
        this.postSource();
        // 6.布置作业、检查作业
        if (this.needHomework()) {
            this.checkHomework();
        }
    }

    // 是否布置作业
    protected boolean needHomework() {
        return false;
    }

    // 检查作业
    abstract void checkHomework();

    // 发布预习资料
    final void postPreResource() {
        System.out.println("发布预习资料");
    }

    // 制作PPT课件
    final void createPPT() {
        System.out.println("制作PPT课件");
    }

    // 在线直播
    final void liveVideo() {
        System.out.println("在线直播");
    }

    // 提交源码笔记
    final void postNote() {
        System.out.println("提交笔记");
    }

    final void postSource() {
        System.out.println("提交源码");
    }

}
