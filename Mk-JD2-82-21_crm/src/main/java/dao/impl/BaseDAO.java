package dao.impl;

import dao.DAO;
import dao.exception.DAOException;


import javax.sql.DataSource;
import java.sql.*;

public class BaseDAO implements DAO {


    protected DataSource dataSource;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws DAOException {
        DataSource dataSourceInit = DataSourceCache.getInstance().getDataSource();
        try {
            return dataSourceInit.getConnection();
        } catch (Exception e) {
            
            throw new DAOException();
        }
    }
    void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {

            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {

            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {

            }
        }
    }
    public void closeConnection() throws DAOException {
        closeDBObjects(null, null, getConnection());
    }

    boolean isEntity(String name, String sql, String column) throws DAOException{
        boolean isName = false;
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, column);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString(column).equals(name)) isName = true;
            }
        } catch (SQLException e) {
            throw new DAOException("Error getting isString. " + e.getMessage());
        } finally {
            closeDBObjects(resultSet, pStatement, connection);
        }
        return isName;
    }

}
