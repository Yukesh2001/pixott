package com.revature.fsd.pixott.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.handler.Top5Movies;

public class Top5MoviesDao {
	public List<Top5Movies> Top() {
		String sql = "select * from  top5movies";
		List<Top5Movies> result = new ArrayList<>();
		try (Connection conn = Util.getConnection(); 
				
				PreparedStatement stmt = conn.prepareStatement(sql);
     		)
		{
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) 
			{
				Top5Movies review = new Top5Movies();
				review.setId(rs.getInt("id"));
				review.setName(rs.getString("name"));
				result.add(review);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
