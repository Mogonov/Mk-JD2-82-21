package dao;

import dao.exception.DAOException;

import javax.sql.DataSource;
import java.sql.Connection;


public interface DAO {
    void setDataSource(DataSource dataSource);
    Connection getConnection() throws DAOException;
}
