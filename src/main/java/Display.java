
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public Connection conn = null;
	public Statement s = null;
	public PreparedStatement p = null;
	RequestDispatcher reqdis = null;

	@Override
	public void init() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
			s = conn.createStatement();
			s.execute("USE STUDENT");

		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error:" + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Submit1")!=null) {
			System.out.println("true");
			String rollno=request.getParameter("rolldis");
			try {
				p = conn.prepareStatement("SELECT * FROM STUD WHERE rollno=?");

				p.setString(1,rollno);
				System.out.print(rollno);
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
				RequestDispatcher reqdis=request.getRequestDispatcher("Display.jsp");
				request.setAttribute("data1",data);
				reqdis.forward(request, response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}


		}
		else if(request.getParameter("Submit2")!=null) {
			System.out.println("false");

			ArrayList<String> ras=new ArrayList<>();
			try {
				s = conn.createStatement();
				ResultSet ab = s.executeQuery("SELECT * FROM STUD");
				String temp="";
				while(ab.next()) {
					temp=ab.getString(1)+"#.@"+ab.getString(2)+"#.@"+ab.getString(3)+"#.@"+ab.getString(4)+"#.@"+ab.getString(5)+"#.@"+ab.getString(6);
					ras.add(temp);
				}


				RequestDispatcher reqdis=request.getRequestDispatcher("Display.jsp");
				request.setAttribute("data2",ras);
				reqdis.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}

		}
	}

}
