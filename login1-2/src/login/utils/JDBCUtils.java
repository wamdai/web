package login.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//提供一个静态方法获取数据源对象
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	//这个源对象还可以返回connection对象
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
}
