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
import java.sql.SQLException;

import com.himedia.member.dto.MemberDto;

public class UpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      Connection con = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/scott";
      String id = "root";
      String pw = "adminuser";
      
      String sql = "select * from members where id=?";
      
      String userid = request.getParameter("id");
      MemberDto mdto = new MemberDto();
      
      try {
         Class.forName(driver);
         con = DriverManager.getConnection(url, id, pw);
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, userid);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            mdto.setId(rs.getString("id"));
//            mdto.setPwd(rs.getString("pwd"));
            mdto.setName(rs.getString("name"));
            mdto.setPhone(rs.getString("phone"));
         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(con!=null) con.close();
            if(pstmt!=null) pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      request.setAttribute("member", mdto);
      RequestDispatcher rd = request.getRequestDispatcher("updateForm.jsp");
      rd.forward(request, response);
   }
   
   

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
         request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         
         Connection con = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         

         String driver = "com.mysql.cj.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/scott";
         String id = "root";
         String pw = "adminuser";

         String userId = request.getParameter("id");
         String name =  request.getParameter("name");
         String pwd =  request.getParameter("pwd");
         String phone =  request.getParameter("phone");
         String sql = "update members set id = ?, name = ?, pwd = ? , phone = ?  where id = ?";
         
         try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,id,pw);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, name);
            pstmt.setString(3, pwd);
            pstmt.setString(4, phone);
            pstmt.setString(5, userId);
            
            pstmt.executeUpdate();
         
            
         } catch (ClassNotFoundException  e) { e.printStackTrace();
         } catch (SQLException e) { e.printStackTrace();
         }finally {
            try {
               if(con!=null) con.close(); 
               if(rs!=null) con.close();
               if(pstmt!=null) con.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
         
         
         response.sendRedirect("start.do");
         
      }


}