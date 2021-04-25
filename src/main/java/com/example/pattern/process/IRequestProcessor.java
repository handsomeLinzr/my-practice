package com.example.pattern.process;

/**
 * 责任链的同一接口
 */
public interface IRequestProcessor {

    /**
     * 处理逻辑
     * @param request
     */
    void process(Request request);

}
