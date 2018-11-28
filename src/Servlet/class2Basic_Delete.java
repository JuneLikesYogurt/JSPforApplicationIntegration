package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.class2_basic;
import dao.class2Basic;

/**
 * Servlet implementation class class2Basic_Delete
 */
@WebServlet("/class2Basic_Delete")
public class class2Basic_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class2Basic_Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Integer id =  Integer.getInteger(request.getParameter("id"));
		
		class2_basic bean = new class2_basic();
		bean.setID(id);
		
		//创建数据库操作对象
		class2Basic dao = new class2Basic();
		
		//如果return的flag为true
		if(dao.delete_class2Basic(id)) {
			//查询basic表,获取所有数据
			List<class2_basic> class2_basic = dao.findAll();
			
			System.out.println("delete" + class2_basic);
			
			request.setAttribute("class2Basic", class2_basic);
			request.getRequestDispatcher("/class2_basic.jsp").forward(request, response);
		} 
	}

}
