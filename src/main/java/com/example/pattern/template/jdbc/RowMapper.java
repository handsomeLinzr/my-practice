package com.example.pattern.template.jdbc;

import java.io.IOException;
import java.sql.ResultSet;

/**
 * 处理结果集
 * @author LZR
 * @date 2020/12/20-20:48
 */
public interface RowMapper<T> {

    // 处理结果集方法
    T mapRow(ResultSet resultSet, int rowNum) throws Exception;

}
