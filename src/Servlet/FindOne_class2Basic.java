package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.class2_basic;
import dao.Conn_class2Basic;
import dao.class2Basic;

/**
 * Servlet implementation class Update_class2Basic
 */
@WebServlet("/FindOne_class2Basic")
public class FindOne_class2Basic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOne_class2Basic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.valueOf(request.getParameter("id"));
		//System.out.println(id);
		try {
			
			Connection conn = Conn_class2Basic.getInstance().getConnection();
			PreparedStatement state = null;
			
			String sql ="select * from basic where id="+id;
			
			state = conn.prepareStatement(sql);
			
			System.out.println(sql);
			
			ResultSet result = state.executeQuery(sql);
			
			List<class2_basic> list = new ArrayList<class2_basic>();
			//虽然只有一个，但是依然遍历结果集
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
			
			//System.out.println("findOne "+ list);
			
			result.close();
			state.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("UpdateClass2_basic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
