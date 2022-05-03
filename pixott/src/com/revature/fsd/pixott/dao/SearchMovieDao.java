package com.revature.fsd.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pixott.handler.SearchMovie;

public class SearchMovieDao {

	public static void Search(String name) {
		String sql = "select * from movie where name like (?)";
		ArrayList<SearchMovie> result = new ArrayList<>();
		try (Connection conn = Util.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("id") + "  ");
				System.out.println(rs.getString("name"));
				
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}