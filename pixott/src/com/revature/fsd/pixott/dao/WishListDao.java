package com.revature.fsd.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WishListDao 
{

	public static void insertWishList(int movieid,int userid) {
		String sql = "insert into wishlist (WishListid,user_id) values (?,?)";
		try(
				Connection connection = Util.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				){
	                 stmt.setInt(1,movieid);
	                 stmt.setInt(2, userid);
	                 stmt.executeUpdate();
		}catch(SQLException e) {
			Util.displayMessage(e);
		}
		
	
	}
}
