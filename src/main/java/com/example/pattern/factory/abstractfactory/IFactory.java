package com.example.pattern.factory.abstractfactory;

/**
 * Description: 工厂抽象，可以生产同哥产品族的所有产品等级结构
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/11/27 4:40 下午
 * @since V1.0.0
 */
public interface IFactory {
    /**
     * 创建笔记📒
     * @return 📒笔记
     */
    INote createNote();

    /**
     * 创建视频
     * @return 视频
     */
    IVideo createVideo();
}
