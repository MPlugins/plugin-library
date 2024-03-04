package net.mplugins.config.database;

import java.sql.*;

public class MySqlDatabaseConnection implements DatabaseConnection {
    private final String username;
    private final String password;
    private final String dsn;

    public MySqlDatabaseConnection(String username, String password, String hostname, String databaseName) {
        this(username, password, hostname, databaseName, 3306);
    }

    public MySqlDatabaseConnection(String username, String password, String hostname, String databaseName, int port) {
        this.username = username;
        this.password = password;
        this.dsn = "jdbc:mysql://" + hostname + ":" + port + "/" + databaseName;
    }

    @Override
    public boolean connect() {
        try {
            final Connection connection = getConnection();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void closeConnection() {

    }

    @Override
    public PreparedStatement prepareStatement(String sql, Connection connection) throws SQLException {
        return connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dsn, username, password);
    }
}
