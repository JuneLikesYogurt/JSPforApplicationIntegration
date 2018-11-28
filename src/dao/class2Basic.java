package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.ArrayList;  
import java.util.List; 

import bean.class2_basic;

public class class2Basic {
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test"; // 数据库地址
	String userName = "root"; // 数据库用户名
	String passWord = "123456"; // 数据库密码

	//增
	public void add_class2Basic(class2_basic bean) {
		Connection conn = null;
		Statement state = null;
		String Cname, Cage, Cgender;
		
//		try {
//			Class.forName(driver);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		try {
			//获取数据库连接
			conn = DriverManager.getConnection(url, userName, passWord);
			
			// SQL语句
			Cname = bean.getName();
			Cage = bean.getAge().toString();
			Cgender = bean.getGender();
			
			String sql = "insert into basic (name, age, gender) values ('"+Cname+"', '"+Cage+"', '"+Cgender+"')";
			System.out.println(sql);
			
			//创建SQL
			state = conn.createStatement();
			//执行SQL语句
			int row = state.executeUpdate(sql);
			if (row != 1) {
				throw new RuntimeException("新增class2的basic表失败!");
			} else {
				System.out.println("新增class2,basic表成功!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//删除
	public boolean delete_class2Basic(int id) {
		Connection conn = null;
		Statement state = null;
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			
			String sql ="delete from basic where id='id' ";
			System.out.println(sql);
			
			//创建SQL
			state = conn.createStatement();
			//执行SQL语句
			int row = state.executeUpdate(sql);
			if(row != 1) {
				throw new RuntimeException("删除class2的basic表失败!");
			} else {
				System.out.println("删除class2,basic表成功!");
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	
	//查询所有的
	public List<class2_basic> findAll() {
		Connection conn = null;
		Statement state = null;
		List<class2_basic> basicList = new ArrayList<class2_basic>();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, userName, passWord);
			
			String sql = "select * from basic";
			//创建执行sql的对象
			state = conn.createStatement();
			//执行sql语句
			ResultSet rs = state.executeQuery(sql);
			
//			System.out.println(sql);
			
			//遍历结果集
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				Integer age = rs.getInt("age");
				String gender = rs.getString("gender");
				
				class2_basic bean = new class2_basic();
				bean.setID(id);
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				
				basicList.add(bean);
				
				System.out.println(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(basicList);
		return basicList;
	}
}
