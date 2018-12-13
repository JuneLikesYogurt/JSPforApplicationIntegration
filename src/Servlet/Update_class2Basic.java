package Servlet;

import java.io.IOException;
import java.sql.Connection;

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
@WebServlet("/Update_class2Basic")
public class Update_class2Basic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_class2Basic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		
		//bean中一定要构造id，给update时的where id=??传值
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		class2_basic bean = new class2_basic();
		//这里也不要忘记设置id
		bean.setID(id);
		bean.setName(name);
		bean.setAge(age);
		bean.setGender(gender);
		
		//System.out.println("update :" + bean);
		
		try {
			class2Basic dao = new class2Basic();
			Connection conn = Conn_class2Basic.getInstance().getConnection();
			dao.update(conn, bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("Find_class2Basic");
	}

}
