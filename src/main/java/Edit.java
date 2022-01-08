

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
	public Connection conn=null;
	public Statement s=null;
	public PreparedStatement p=null;
	public String rollno;
	RequestDispatcher reqdis=null;
    @Override
	public void init() {
        // TODO Auto-generated constructor stub
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/","root", "");
            s=conn.createStatement();
            s.execute("USE STUDENT");

        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Submit1")!=null) {
			rollno=request.getParameter("Uproll");
			try {
				p = conn.prepareStatement("SELECT * FROM STUD WHERE rollno=?");

				p.setString(1,rollno);
				//System.out.print(rollno);
				ResultSet rs=null;
				rs = p.executeQuery();
				rs.next();
				ArrayList<String> data=new ArrayList<>();
				data.add(rs.getString("name"));
				data.add(rs.getString("rollno"));
				data.add(rs.getString("age"));
				data.add(rs.getString("dept"));
				data.add(rs.getString("email"));
				data.add(rs.getString("phno"));
				RequestDispatcher reqdis=request.getRequestDispatcher("Edit.jsp");
				request.setAttribute("data",data);
				reqdis.forward(request, response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else if(request.getParameter("Submit2")!=null) {


			  String rl=request.getParameter("Roll");
			  System.out.println(rl);
		      String str1=request.getParameter("Name");
		      System.out.println(str1);
		      String str2=request.getParameter("Age");
		      String str3=request.getParameter("phno");
		      String str4=request.getParameter("email");
		      String str5=request.getParameter("dept");
		      try {
		    	p = conn.prepareStatement("UPDATE STUD SET name=?,age=?,phno=?,email=?,dept=? WHERE rollno=?");
		    	p.setString(1, str1);
		    	p.setString(2, str2);
		    	p.setString(3, str3);
		    	p.setString(4, str4);
		    	p.setString(5, str5);
		    	p.setString(6, rl);
		    	p.executeUpdate();
			    response.sendRedirect("Edit.jsp");
	      }
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }

		}
	}

}
