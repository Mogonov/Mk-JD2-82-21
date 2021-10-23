package dao.impl;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DataSourceCache {

    private static DataSourceCache instance;
    private DataSource dataSource;
    static {
        instance = new DataSourceCache();
    }

    private DataSourceCache() {
        Context context;
        try {
            context = new InitialContext();
            dataSource = (DataSource) context.lookup(
                    "java:comp/env/jdbc/postgres");
        } catch (NamingException e) {
          
        }
    }

    public static DataSourceCache getInstance() {
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
