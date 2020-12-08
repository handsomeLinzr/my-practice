package com.example.pattern.prototype.deep;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 3:11 下午
 * @since V1.0.0
 */
public class DeepCloneTest {

    @Test
    public void test1() {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        qiTianDaShen.weight = 100;
        qiTianDaShen.height = 1000;
        QiTianDaShen shallowClone = qiTianDaShen.shallowClone();
        System.out.println(qiTianDaShen == shallowClone);
        System.out.println(qiTianDaShen.getJinGuBang() == shallowClone.getJinGuBang());
        System.out.println(qiTianDaShen.getJinGuBang().hashCode() == shallowClone.getJinGuBang().hashCode());
    }

    @Test
    public void test2() throws Exception {
        QiTianDaShen qiTianDaShen = new QiTianDaShen();
        QiTianDaShen clone = qiTianDaShen.clone();
        System.out.println(qiTianDaShen == clone);
        System.out.println(qiTianDaShen.birthday == clone.birthday);
        System.out.println(qiTianDaShen.getJinGuBang() == clone.getJinGuBang());
        System.out.println(System.identityHashCode(qiTianDaShen));
        System.out.println(System.identityHashCode(clone));
        System.out.println(qiTianDaShen.getJinGuBang().hashCode());
        System.out.println(clone.getJinGuBang().hashCode());
        clone.getJinGuBang().setH(11);
        System.out.println(clone.getJinGuBang().hashCode());
        System.out.println(System.identityHashCode(clone));
    }

}
