package net.mplugins.config.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DatabaseConnection {
    boolean connect();

    void closeConnection();

    PreparedStatement prepareStatement(String sql, Connection connection) throws SQLException;

    Connection getConnection() throws SQLException;
}
