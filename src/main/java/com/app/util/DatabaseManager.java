package com.app.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final Logger logger = LogManager.getLogger(DatabaseManager.class);
    private static final String DATABASE_URL = "jdbc:sqlite:tasks.db";


    static {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS tasks (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " name TEXT NOT NULL,\n"
                    + " value TEXT NOT NULL,\n"
                    + " description TEXT\n"
                    + ");";
            stmt.execute(sql);
        } catch (SQLException e) {
            logger.error("Failed to create table", e);
        }
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL);
        } catch (SQLException e) {
            logger.error("Failed to get database connection", e);
        }
        return null;
    }
}