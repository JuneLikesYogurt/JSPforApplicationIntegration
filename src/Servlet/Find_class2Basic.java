package Servlet;

import java.io.IOException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conn_class2Basic;
import bean.class2_basic;

/**
 * Servlet implementation class Find_class2Basic
 */
@WebServlet("/Find_class2Basic")
public class Find_class2Basic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_class2Basic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Connection conn = Conn_class2Basic.getInstance().getConnection();
			
			String sql = "select * from basic";
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery(sql);
			
			List<class2_basic> list = new ArrayList<class2_basic>();
			//遍历结果集
			while(result.next()) {
				class2_basic bean = new class2_basic();
				bean.setID(result.getInt("id"));
				bean.setName(result.getString("name"));
				bean.setAge(result.getInt("age"));
				bean.setGender(result.getString("gender"));
				list.add(bean);
				
				//System.out.println(bean);
			}
			request.setAttribute("list", list);
			result.close();
			state.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("FindClass2_basic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
