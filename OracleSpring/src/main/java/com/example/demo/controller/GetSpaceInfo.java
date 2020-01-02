package com.example.demo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DbcpUtil;

@RestController
public class GetSpaceInfo {

	@RequestMapping("test")
	public String hello() {
		Connection connection=DbcpUtil.getConn();
		try {
			Statement statement = connection.createStatement();
			String sql = "select tablespace_name,round(used_space*8/1024,2)as \"used\",round(tablespace_size*8/1024,2) as \"size\",used_percent from \r\n" + 
					"dba_tablespace_usage_metrics t where tablespace_name like 'TBS%' order by t.used_percent desc";
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getDouble("used"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "hello";
	}

	
}
