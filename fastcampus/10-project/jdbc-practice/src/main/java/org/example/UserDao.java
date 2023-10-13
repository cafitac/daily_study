package org.example;

import java.sql.SQLException;

public class UserDao {

    public void create(final User user) throws SQLException {
        final JDBCTemplate jdbcTemplate = new JDBCTemplate();

        final String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(sql, pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
        });
    }

    public User findByUserId(final String userId) throws SQLException {
        final JDBCTemplate jdbcTemplate = new JDBCTemplate();

        final String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
        return (User) jdbcTemplate.executeQuery(sql,
            pstmt -> pstmt.setString(1, userId),
            rs -> new User(
                rs.getString("userId"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email")
            ));
    }
}
