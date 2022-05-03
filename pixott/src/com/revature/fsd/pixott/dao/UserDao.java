package com.revature.fsd.pixott.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pixott.model.User.User;

public class UserDao {
	public static int id;
	public void signup(User user) {
		String sql="insert into user(name,mobile,password)values(?,?,?)";
		
		try (
				Connection conn=Util.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql);
				){
			System.out.println("connected succesfully.");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getMobile());
			stmt.setString(3, user.getPassword());
			stmt.executeUpdate();
            System.out.println("user added successfully");
		}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
		    }
	}
		public User getLogin(String mobile){
		     String sql = "select * from user where mobile = ?";
				try (
						Connection conn = Util.getConnection(); 
						PreparedStatement stmt = conn.prepareStatement(sql);
						)
				{
					stmt.setString(1, mobile);
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setMobile(rs.getString("mobile"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						id=user.getId();
						return user;
					} else {
						System.out.println("invalid login details");
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				return 	null;
		     }
}
		
		
	/*public static void main(String[]args)
	{
		UserDao dao=new UserDao();
		User user=new User();
	    user.setName("john");
		user.setMobile("9876543210");
		user.setPassword("password123");
		dao.signup(user);
	 }
	}
*/