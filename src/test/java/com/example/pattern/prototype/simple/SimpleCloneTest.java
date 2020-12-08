package com.example.pattern.prototype.simple;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author Linzr
 * @version V1.0.0
 * @date 2020/12/8 10:18 上午
 * @since V1.0.0
 */
public class SimpleCloneTest {

    // 只克隆基础类型数据和字符串，对象引用只拷贝引用，指针还是指向原对象
    @Test
    public void test1() {
        ConPrototype conPrototype = new ConPrototype();
        conPrototype.setName("阿哲");
        conPrototype.setAge(18);
        List<String> hobbies = new ArrayList<>();
        hobbies.add("篮球");
        conPrototype.setHobbies(hobbies);

        Client client = new Client(conPrototype);
        ConPrototype clone = (ConPrototype) client.startClone();
        System.out.println(conPrototype == clone);    // false
        System.out.println(conPrototype.getHobbies() == clone.getHobbies());  // true
        System.out.println("地址：");
        System.out.println(System.identityHashCode(conPrototype.getHobbies()));  // 1970881185
        System.out.println(System.identityHashCode(clone.getHobbies()));         // 1970881185
        System.out.println(System.identityHashCode(conPrototype.getName()));     // 1250391581
        System.out.println(System.identityHashCode(clone.getName()));            // 1250391581

        System.out.println(conPrototype.getHobbies());
        System.out.println(clone.getHobbies());
        System.out.println(conPrototype.getName());
        System.out.println(clone.getName());

        hobbies.add("足球");
        conPrototype.name = "shuai";
        System.out.println(conPrototype.getHobbies());
        System.out.println(clone.getHobbies());
        System.out.println(conPrototype.getName());
        System.out.println(clone.getName());
        System.out.println("地址");
        System.out.println(System.identityHashCode(conPrototype.getHobbies()));    // 1970881185
        System.out.println(System.identityHashCode(clone.getHobbies()));           // 1970881185
        System.out.println(System.identityHashCode(conPrototype.getName()));       // 1725017993
        System.out.println(System.identityHashCode(clone.getName()));              // 1250391581
        System.out.println(System.identityHashCode(conPrototype.getAge()));        // 140799417
        System.out.println(System.identityHashCode(clone.getAge()));               // 140799417
        conPrototype.age = 22;
        System.out.println(System.identityHashCode(conPrototype.getAge()));        // 926370398
        System.out.println(System.identityHashCode(clone.getAge()));               // 140799417
    }

    @Test
    public void test2() throws CloneNotSupportedException {
        ConPrototypeB conPrototypeB = new ConPrototypeB();
        conPrototypeB.setAge(20);
        conPrototypeB.setName("阿哲");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("basketball");
        conPrototypeB.setHobbies(hobbies);

        // 浅克隆
        ConPrototypeB clone = conPrototypeB.clone();
        System.out.println(conPrototypeB == clone);
        System.out.println(conPrototypeB.getAge() == clone.getAge());
        System.out.println(conPrototypeB.getName() == clone.getName());
        System.out.println(conPrototypeB.getHobbies() == clone.getHobbies());

        System.out.println(conPrototypeB.getHobbies());
        System.out.println(clone.getHobbies());
        System.out.println(conPrototypeB.getHobbies().hashCode());
        System.out.println(clone.getHobbies().hashCode());
        hobbies.add("football");
        System.out.println(conPrototypeB.getHobbies());
        System.out.println(clone.getHobbies());
        System.out.println(conPrototypeB.getHobbies().hashCode());
        System.out.println(clone.getHobbies().hashCode());
    }

    @Test
    public void test3() {
        // list每次增加元素地址都会改变
        List<String> list = new ArrayList<>();
        list.add("a");
        System.out.println(list.hashCode());
        System.out.println(System.identityHashCode(list));
        list.add("b");
        System.out.println(list.hashCode());
        System.out.println(System.identityHashCode(list));
        System.out.println("=========================");
        List<String> list1 = list;    // 不会开辟堆空间
        System.out.println(list1.hashCode());
        System.out.println(System.identityHashCode(list1));
        System.out.println("----------------------------------------------");
        list.add("c");
        System.out.println(list.hashCode());
        System.out.println(list1.hashCode());
        System.out.println(System.identityHashCode(list));
        System.out.println(System.identityHashCode(list1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
