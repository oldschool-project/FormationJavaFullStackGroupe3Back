package com.slack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.slack.entity.Message;
import com.slack.entity.User;

public class ChatApiDAO {

	private static ChatApiDAO instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/chat_api";

	public static ChatApiDAO getInstance() throws Exception {

		if (instance == null)
			instance = new ChatApiDAO();
		return instance;
	}

	public ChatApiDAO() throws NamingException {

		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {

		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}

	private Connection getConnection() throws SQLException {

		Connection myConnection = dataSource.getConnection();
		return myConnection;
	}

	private void close(Connection connection, Statement stmt, ResultSet res) {

		try {

			if (connection != null)
				connection.close();
			if (stmt != null)
				stmt.close();
			if (res != null)
				res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(User u) {

		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO users (username, email, password) VALUES (?,?,?)";

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}

	}

	public void deleteUser(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "DELETE FROM users WHERE id=?";

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public List<User> getAllUser() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users";

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
//				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				users.add(buildUser(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return users;
	}
	

	public List<User> getAllUsernames() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		String query = "SELECT id, username FROM users";
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), null, null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	public User getUser(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		String query = "SELECT * FROM users WHERE id=?";

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			u = buildUser(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return u;
	}

	public User getUser(String username) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		String query = "SELECT * FROM users WHERE username=?";

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			u = buildUser(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return u;
	}

	private User buildUser(ResultSet rs) {

		User u = null;
		try {
			while (rs.next()) {
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public void updateUser(User u) {

		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "UPDATE users set username=?, email=?, password=? WHERE id=?";

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getEmail());
			stmt.setString(3, u.getPassword());
			stmt.setInt(4, u.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public List<Integer> getAllUserOfChannel(int channelId) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT user_id FROM user_channel WHERE canal_id=?";
		List<Integer> usersId = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, channelId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				usersId.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return usersId;
	}

	public List<Integer> getAllChannelsOfUser(int userId) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT canal_id FROM user_channel WHERE user_id=?";
		List<Integer> channelsId = new ArrayList<>();

		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, userId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				channelsId.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, rs);
		}

		return channelsId;
	}

	public void addMessage(Message m) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String query = "INSERT INTO messages (content, created_at, updated_at, canal_id, user_id) VALUES (?,?,?,?,?)";
		
		System.out.println("message m = " + m);
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, m.getContent());
			stmt.setDate(2, new java.sql.Date(m.getCreationDate().getTime()));
			stmt.setDate(3, new java.sql.Date(m.getUpdateDate().getTime()));
			stmt.setInt(4, m.getChannelId());
			stmt.setInt(5, m.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}
	}

	public List<Message> getAllMessages() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT username, messages.id, content, created_at, updated_at, canal_id, user_id FROM users INNER JOIN messages ON messages.user_id = users.id ORDER BY created_at ASC";
		List<Message> messages = new ArrayList<>();

		try {
			conn = getConnection();
			rs = conn.createStatement().executeQuery(query);

			while (rs.next()) {
				Message m = new Message(rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6),
						rs.getInt(7));
				m.setUsername(rs.getString(1));
				messages.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, stmt, null);
		}

		return messages;
	}
}
