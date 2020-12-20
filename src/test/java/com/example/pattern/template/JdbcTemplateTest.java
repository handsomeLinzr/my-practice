package com.example.pattern.template;

import com.example.pattern.template.jdbc.MemberDao;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author LZR
 * @date 2020/12/20-21:18
 */
public class JdbcTemplateTest {

    @Test
    public void test() {
        MemberDao memberDao = new MemberDao(null);
        List<?> objects = memberDao.selectAll();
    }

}
