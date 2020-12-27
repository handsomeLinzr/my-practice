package com.example.pattern.observer.moments;

/**
 * 发送内容
 * @author LZR
 * @date 2020/12/27-18:45
 */
public class Content {
    // 发送者
    private String publisher;

    // 标题
    private String title;

    // 内容
    private String content;

    public Content(String publisher, String title, String content) {
        this.publisher = publisher;
        this.title = title;
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
