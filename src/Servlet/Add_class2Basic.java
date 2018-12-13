package Servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import bean.class2_basic;
import dao.Conn_class2Basic;
import dao.class2Basic;

import dao.class2Basic;
/**
 * Servlet implementation class Add_Servlet
 */

//注册Servlet
@WebServlet("/Add_class2Basic")


public class Add_class2Basic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_class2Basic() {
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
		
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		
		class2_basic bean = new class2_basic();
		bean.setName(name);
		bean.setAge(age);
		bean.setGender(gender);
		
		System.out.println(bean.getID());
		
		try {
			class2Basic dao = new class2Basic();
			Connection conn = Conn_class2Basic.getInstance().getConnection();
			dao.add(conn, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		//List<class2_basic> class2_basic = dao.findAll();
		//System.out.println(class2_basic);
		
		//request.setAttribute("class2Basic", class2_basic);
		
		request.getRequestDispatcher("/AddClass2_basic.jsp").forward(request, response);
	}

}
