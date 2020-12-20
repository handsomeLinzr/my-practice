package com.example.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Jdbc模板，由于对数据库的操作是有一定流程的，故可以将其应用模板模式
 * @author LZR
 * @date 2020/12/20-17:37
 */
public abstract class AbstractJdbcTemplate<M> {

    private DataSource dataSource;

    public AbstractJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    // 执行查询操作
    public List<?> executeQuery(String sql, Object[] params, RowMapper<?> rowMapper) {
        try {
            // 1. 获得连接
            Connection connection = this.getConnection();
            // 2. 创建语句集
            PreparedStatement preparedStatement = this.createPreparedStatement(connection, sql);
            // 3. 执行语句集
            ResultSet resultSet = this.executeQuery(preparedStatement, params);
            // 4. 处理结果集
            List<?> result = this.paresResultSet(resultSet, rowMapper);
            // 6. 关闭结果集
            this.closeResultSet(resultSet);
            // 7. 关闭语句集
            this.closePrepareStatement(preparedStatement);
            // 8. 关闭连接
            this.closeConnection(connection);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获得连接
    protected Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    // 创建语句集
    protected PreparedStatement createPreparedStatement(Connection connection, String sql) throws Exception {
        return connection.prepareStatement(sql);
    }

    // 执行语句集
    protected ResultSet executeQuery(PreparedStatement preparedStatement, Object[] params) throws Exception {
        // 设置参数
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i, params[i]);
        }
        return preparedStatement.executeQuery();
    }

    // 处理结果集
    protected List<?> paresResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (resultSet.next()) {
            result.add(rowMapper.mapRow(resultSet, rowNum ++));
        }
        return result;
    }

    // 关闭结果集
    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    // 关闭语句集
    protected void closePrepareStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    // 关闭连接
    protected void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

}
