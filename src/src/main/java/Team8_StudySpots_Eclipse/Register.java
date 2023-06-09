package src.main.java.Team8_StudySpots_Eclipse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class Register extends HttpServlet {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String userEmail = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	 
	    int id = 0;
	    
	    
	    
	    try {
	        //System.out.println("made it here222"); 
	        
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("made it here" + "fname=" + firstName);
	        
	        conn = DriverManager.getConnection("jdbc:mysql://localhost/USCStudySpots?user=root&password=cx3M1-lMp2R-JdnxK");
	 
	        String query = "INSERT IGNORE INTO Users (firstName, lastName, password, userEmail) VALUES (?, ?, ?, ?)";
	        pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	        pst.setString(1, firstName);
	        pst.setString(2, lastName);
	        pst.setString(3, password);
	        pst.setString(4, userEmail);
	   

	        //int rowsInserted = pst.executeUpdate();
	        /*if (rowsInserted > 0) {
	        	try {
	        	    response.setContentType("text/plain");
	        	    rs = pst.getGeneratedKeys();
	        	    if (rs.next()) {
	                    id = rs.getInt(1);
	                }
	        	    String r = Integer.toString(id);
	    			response.getWriter().write(r);
	    			response.getWriter().flush();
	    			response.getWriter().close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
        	}
	        else {
	        	try {
	        	    response.setContentType("text/plain");
	    			response.getWriter().write("404");
	    			response.getWriter().flush();
	    			response.getWriter().close();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }*/
	        } catch (SQLException sqle) {
	        	System.out.println("SQL Exception: " + sqle.getMessage());
	        } catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (pst != null) {
						pst.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException sqle) {
					System.out.println("SQL Exception: " + sqle.getMessage());
				}
			}
	    
		//System.out.println(id);
	}
}
