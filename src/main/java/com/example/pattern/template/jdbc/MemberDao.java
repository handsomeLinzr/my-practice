package com.example.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * dao数据访问层
 * @author LZR
 * @date 2020/12/20-21:07
 */
public class MemberDao extends AbstractJdbcTemplate<Member>{

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() {
        String sql = "select * from Member";
        return super.executeQuery(sql, null, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(resultSet.getString("username"));
                member.setPassword(resultSet.getString("password"));
                member.setNickname(resultSet.getString("nickname"));
                member.setAge(resultSet.getInt("age"));
                return member;
            }
        });
    }

}
