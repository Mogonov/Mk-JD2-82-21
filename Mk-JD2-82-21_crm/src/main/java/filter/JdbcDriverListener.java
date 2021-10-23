package filter;


import dao.exception.DAOException;
import dao.impl.BaseDAO;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;


@WebListener
public class JdbcDriverListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Context envCtx = (Context) new InitialContext().lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/postgres");
            sce.getServletContext().setAttribute("DBCPool", ds);
        } catch (NamingException e) {

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        BaseDAO dbManager = (BaseDAO) ctx.getAttribute("DBCPool");
        try {
            dbManager.closeConnection();
        } catch (DAOException e) {
            
        }

    }


}
