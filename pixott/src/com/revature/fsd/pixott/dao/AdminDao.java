package com.revature.fsd.pixott.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pixott.handler.Movie;

public class AdminDao {
		public static void showFullMovie() {
			String sql = "select * from movie";
			List<Movie> movies = new ArrayList<>();
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Movie movie = new Movie();
					movie.setId(rs.getInt("id"));
					movie.setName(rs.getString("name"));
					movie.setGenre(rs.getString("genre"));
					movie.setYear(rs.getInt("year"));
					movies.add(movie);
				}
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
			MovieDao.print();
			movies.forEach(System.out::println);
		}

		public static void addMovie(String name, String genre, double sales, int year) {
			String sql = String.format("insert into movie (name,genre,sales,year) values (?,?,?,?)");
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setString(1, name);
				stmt.setString(2, genre);
				stmt.setDouble(3, sales);
				stmt.setInt(4, year);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}

		public static void changeTopFiveMovie(int update, int remove) {
			String sql = "update topfivemovie set topfivemovieid =? where topfivemovieid=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setInt(1, update);
				stmt.setInt(2, remove);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}

		public static void makeUnavailable(int id) {
			String sql = "update movie set availability = 'unavailable' where id=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}

		public static void modifyMovieName(String update, int remove) {
			String sql = "update movie set name ='?' where id=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setString(1, update);
				stmt.setInt(2, remove);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}

		public static void modifyMovieGenre(String update, int remove) {
			String sql = "update movie set genre ='?' where id=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setString(1, update);
				stmt.setInt(2, remove);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}
		
		public static void modifyMovieSales(int update, int remove) {
			String sql = "update movie set sales =? where id=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setInt(1, update);
				stmt.setInt(2, remove);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}
		
		public static void modifyMovieYear(int update, int remove) {
			String sql = "update movie set year =? where id=?";
			try (Connection connection = Util.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql);) {
				stmt.setInt(1, update);
				stmt.setInt(2, remove);
				stmt.executeUpdate();
			} catch (SQLException e) {
				Util.displayMessage(e);
			}
		}

	}

