package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import bean.class2_basic;
import dao.class2Basic;

/**
 * Servlet implementation class class2
 */
@WebServlet("/class2Basic_Servlet")
public class class2Basic_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public class2Basic_Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//设置编码,防止相应乱码
				req.setCharacterEncoding("UTF-8");
				
				//获取参数
				String name = req.getParameter("name");
				Integer age = Integer.parseInt(req.getParameter("age"));//注意age是Integer型
				String gender = req.getParameter("gender");
				
				//创建class2_basic对象,保存信息
				class2_basic bean = new class2_basic();
				bean.setName(name);
				bean.setAge(age);
				bean.setGender(gender);
				
				System.out.println(bean.getID());
				
				//创建数据库操作对象
				class2Basic dao = new class2Basic();
				//查询basic表
				
				//新增 class2数据库,basic表 的数据到数据库
				dao.add_class2Basic(bean);

				//查询basic表
				List<class2_basic> class2_basic = dao.findAll();
//				System.out.println(class2_basic);
				
				req.setAttribute("class2Basic", class2_basic);//参数参考上一行代码
				
				//转发请求
				req.getRequestDispatcher("/class2_basic.jsp").forward(req, resp);
		
	}

}
