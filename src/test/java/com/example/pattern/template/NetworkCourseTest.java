package com.example.pattern.template;

import com.example.pattern.template.network.BigDataNetworkCourse;
import com.example.pattern.template.network.JavaNetworkCourse;
import com.example.pattern.template.network.NetworkCourse;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author LZR
 * @date 2020/12/19-14:54
 */
public class NetworkCourseTest {

    @Test
    public void test1() {
        NetworkCourse networkCourse = new JavaNetworkCourse();
        // 调用后直接会根据模板流程进行顺序输出
        networkCourse.createCourse();
    }

    @Test
    public void test2() {
        NetworkCourse networkCourse = new BigDataNetworkCourse(true);
        networkCourse.createCourse();
    }

}
