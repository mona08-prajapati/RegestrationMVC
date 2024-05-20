package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import util.DbUtil;

public class UserDao {
	
		
		private static Connection connection = null;
	
	
	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user(firstname,lastname,username,password,id) values (?, ?, ?, ? ,?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getId());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}}
	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	
		
	}
	public static User getUser(User user1) {
		if(null!="username"&&null!="password") {
			if(connection!=null) {
				try {
					
					PreparedStatement statement=connection.prepareStatement("select * from user where username=? and password=?");
					statement.setString(1, user1.getUsername());
					statement.setString(2, user1.getPassword());
					ResultSet resultset=statement.executeQuery();
					while(resultset.next()) {
					
						user1.setFirstname(resultset.getString(1));
					user1.setLastname(resultset.getString(2));
					}}
					catch (SQLException e) {
						e.printStackTrace();
					}
			}}
		             return user1;
		             }
	public static User getUser1(User user) {
		if(null!="firstname"&&null!="lastname"&&null!="username"&&null!="password") {
			if(connection!=null) {
				try {
				
					PreparedStatement statement=connection.prepareStatement("select * from user where firstname=?,lastname=?,username=?,password=?");
					statement.setString(1, user.getFirstname());
					statement.setString(2, user.getLastname());
					statement.setString(2, user.getUsername());
					statement.setString(2, user.getPassword());
					ResultSet resultset=statement.executeQuery();
					while(resultset.next()) {
				
						user.setFirstname(resultset.getString(1));
					user.setLastname(resultset.getString(2));
					}}
					catch (SQLException e) {
						e.printStackTrace();
					}
			}}
		             return user;
		             }
	
}



	
