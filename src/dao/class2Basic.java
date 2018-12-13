package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.class2_basic;

public class class2Basic {
	private PreparedStatement state = null;
	//private ResultSet result =null;
	
	public class2Basic () {
		// todo 
	}
	
	public void add(Connection conn, class2_basic bean) {
		//PreparedStatement state = null;
		String Cname, Cage, Cgender;
		
		try {
			Cname = bean.getName();
			Cage = bean.getAge().toString();
			Cgender = bean.getGender();
			
			String sql = "insert into basic (name, age, gender) values ('"+Cname+"', '"+Cage+"', '"+Cgender+"')";
			System.out.println(sql);
			
			state = conn.prepareStatement(sql);
			//执行SQL
			int row = state.executeUpdate(sql);
			if (row != 1) {
				throw new RuntimeException("新增class2，basic失败!");
			} else {
				System.out.println("新增 class2,basic成功!");
			}
		}  catch (SQLException e) {
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
	
	public void findAll() {}
	
	public void delete(Connection conn,int id) throws SQLException {
		String sql = "delete from basic where id=? ";
		try {
			state = conn.prepareStatement(sql);
			//对SQL语句中的第一个占位符赋值
			state.setInt(1, id);
			state.executeUpdate();
			
			System.out.printf(sql);
		} finally {
			if (null != state) {
				state.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
	}
	
	public void update(Connection conn, class2_basic bean) throws SQLException {
		//System.out.println(bean);
		
		Integer id= bean.getID();
		//System.out.println(id);
		
		String Cname, Cage, Cgender;
		
		try {
			Cname = bean.getName();
			Cage = bean.getAge().toString();
			Cgender = bean.getGender();
			
			String sql = "update basic set name='"+Cname+"',age="+Cage+",gender='"+Cgender+"' where id="+id;
			System.out.println(sql);
			
			state = conn.prepareStatement(sql);
			
			//执行SQL
			//int row = state.executeUpdate(sql);
			state.executeUpdate();
			
//			if (row != 1) {
//				throw new RuntimeException("修改class2，basic失败!");
//			} else {
//				System.out.println("修改class2,basic成功!");
//			}
		}  catch (SQLException e) {
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
}
