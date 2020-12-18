package sk.itsovy.dolinsky.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Martin Dolinsky
 */
@WebServlet(name = "TestDbServlet", urlPatterns = {"/dbserv"})
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String user = "springstudent";
    	String pass = "springstudent";

    	String jdbcUrl = "jdbc:mysql://localhost:8889/web_customer_tracker?useSSL=false&serverTimezone=UTC";
    	String driver = "com.mysql.jdbc.Driver";

		try{
			PrintWriter out = response.getWriter();
			out.println("Connecting to DB: " + jdbcUrl);
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("Successful");
			connection.close();

		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
    }
}
