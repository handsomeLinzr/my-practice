package com.example.pattern.prototype.deep;

import java.io.*;
import java.time.LocalDate;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 1:40 下午
 * @since V1.0.0
 */
public class QiTianDaShen extends Monkey implements Cloneable, Serializable {
    private JinGuBang jinGuBang;

    public JinGuBang getJinGuBang() {
        return jinGuBang;
    }

    public void setJinGuBang(JinGuBang jinGuBang) {
        this.jinGuBang = jinGuBang;
    }

    public QiTianDaShen() {
        System.out.println("constructor");
        this.birthday = LocalDate.now();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected QiTianDaShen clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    // 深拷贝
    public QiTianDaShen deepClone() {
        QiTianDaShen qiTianDaShen = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            qiTianDaShen = (QiTianDaShen) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return qiTianDaShen;
    }

    // 浅拷贝
    public QiTianDaShen shallowClone() {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        qiTianDaShen.birthday = LocalDate.now();
        qiTianDaShen.jinGuBang = this.jinGuBang;
        qiTianDaShen.height = this.height;
        qiTianDaShen.weight = this.weight;
        return qiTianDaShen;
    }

}
