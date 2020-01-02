package com.example.demo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.stereotype.Component;

@Component
public class DbcpUtil {
	private static DataSource dataSource;
	static {		
		//InputStream is = DbcpUtil.class.getClassLoader().getResourceAsStream("src/main/resources/db.properties");
		
		//InputStream is = DbcpUtil.class.getResourceAsStream("/src/main/resources/db.properties");
		Properties p = new Properties();
		
		//System.out.println(p.getProperty("driverClassName"));
		p.setProperty("driverClassName", "oracle.jdbc.driver.OracleDriver");
		p.setProperty("url", "jdbc:oracle:thin:@192.168.1.178:1521:orcl");
		p.setProperty("username", "dwusr");
		p.setProperty("password", "123456");
		p.setProperty("maxActive", "100");
		p.setProperty("initialSize", "5");
		p.setProperty("maxIdle", "5");
		p.setProperty("minIdle", "3");
		p.setProperty("maxWait", "10000");
		try {
			//p.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(p);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		return null;
		}
	public static void close(Connection conn,Statement st,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} finally{
						rs = null;
						}
			}
		if(st != null) {
			try {
				st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} finally{
						st = null;
						}
			}
		if(conn != null) {
			try {
				conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} finally{
						conn = null;
						}
			}
		}
	}
