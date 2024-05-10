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
import java.sql.SQLException;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		   PreparedStatement pstmt = null;
		   String driver = "com.mysql.cj.jdbc.Driver";
		   String url = "jdbc:mysql://localhost:3306/scott";
		   String id="root";
		   String pw="adminuser";
		   String userid = request.getParameter("id");
		   String sql = "delete * from MEMBERS where id=?";
		   try {
		         Class.forName(driver);
		         con = DriverManager.getConnection(url, id, pw);
		         pstmt = con.prepareStatement(sql);
		         pstmt.setString(1, userid);
		         pstmt.executeUpdate();
		   }catch (Exception e) {
		         e.printStackTrace();
		      }finally {
		         try {
		            if(con!=null) con.close();
		            if(pstmt!=null) pstmt.close();
		         } catch (Exception e) {
		            e.printStackTrace();
		         }
		         request.setAttribute("delete", "ok");

		      }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
