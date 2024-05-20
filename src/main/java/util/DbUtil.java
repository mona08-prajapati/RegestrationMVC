package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import constants.UserConstants;
import jakarta.servlet.http.HttpServletRequest;

public class DbUtil {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }public static String validateRequest1(HttpServletRequest request) {
		String error1=null;
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		
		if(firstname.isEmpty()||lastname.isEmpty()||username.isEmpty()) 
		{
			error1=UserConstants.EMPTY_FIRSTNAME_LASTNAME;
		}
	return error1;
    }
	public static String validateRequest(HttpServletRequest request) {
		String error=null;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.isEmpty()||password.isEmpty()) 
		{
			error=UserConstants.EMPTY_USERNAME_PASSWORD;
		}
		return error;
	

	
	}

}
	


