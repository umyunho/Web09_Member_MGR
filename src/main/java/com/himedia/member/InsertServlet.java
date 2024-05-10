package com.himedia.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**est, HttpServletResponse response) throws ServletException, I
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insertForm.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		Connection con = null;
		PreparedStatement pstmt = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/scott";
		String id="root";
		String pw="adminuser";
		   
		String sql = "insert into members(id, name, pwd, phone) values( ?, ?, ?, ?)";
		   
		String userid= request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone= request.getParameter("phone");
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url,id,pw);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setString(2,name);
			pstmt.setString(3,pwd);
			pstmt.setString(4,phone);
			pstmt.executeUpdate();
	}catch(Exception e){e.printStackTrace();
	}finally{
		try{
			if(con!=null)con.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception e){e.printStackTrace();
		}
		}
		RequestDispatcher rd = request.getRequestDispatcher("start.do");
		rd.forward(request, response);
	}

}


















