
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Extend HttpServlet class to create Http Servlet
@SuppressWarnings("serial")
public class servlets extends HttpServlet {

   public String dbcreate="CREATE DATABASE IF NOT EXISTS STUDENT";
   public Connection conn=null;
   public Statement s=null;
   public String tableCreate="CREATE TABLE IF NOT EXISTS STUD (name VARCHAR(100),rollno VARCHAR(100) PRIMARY KEY,age VARCHAR(100)"
   		+ ",phno VARCHAR(100),email VARCHAR(100),dept VARCHAR(100));";
   public  PreparedStatement p;
   @Override
public void init() throws ServletException {
	   try {
           Class.forName("com.mysql.jdbc.Driver");
           conn = null;
           conn = DriverManager.getConnection("jdbc:mysql://localhost/","root", "");
           s=conn.createStatement();
           s.execute(dbcreate);
           s.execute("USE STUDENT");
           System.out.print("Database is connected !");
           s.execute(tableCreate);
           System.out.print("Table created !");

       }
       catch(Exception e) {
           System.out.print("Do not connect to DB - Error:"+e);
       }
   }

   @Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	   String str1=request.getParameter("Name");
	      String str2=request.getParameter("Roll");
	      String str3=request.getParameter("Age");
	      String str4=request.getParameter("phno");
	      String str5=request.getParameter("email");
	      String str6=request.getParameter("dept");
	      try {
	    	p = conn.prepareStatement("INSERT INTO STUD VALUES(?,?,?,?,?,?);");
	    	p.setString(1, str1);
	    	p.setString(2, str2);
	    	p.setString(3, str3);
	    	p.setString(4, str4);
	    	p.setString(5, str5);
	    	p.setString(6, str6);
	    	p.executeUpdate();
	      }
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	      response.sendRedirect("index.html");

	   }

   @Override
public void destroy() {
      /* leaving empty for now this can be
       * used when we want to do something at the end
       * of Servlet life cycle
       */
   }
}
