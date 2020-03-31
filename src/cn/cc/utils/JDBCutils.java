package cn.cc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class JDBCutils {
    private static DataSource ds;
    static {
        try {
            Properties pro = new Properties();
            pro.load(Objects.requireNonNull(JDBCutils.class.getClassLoader().getResourceAsStream("durid.properties")));
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取数据库连接
     */

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }


}
