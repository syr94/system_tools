package com.app.repository;

import com.app.model.Task;
import com.app.util.DatabaseManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static final Logger logger = LogManager.getLogger(TaskRepository.class);

    public Task getTaskByName(String name) {
        Task task = null;
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM tasks WHERE name = ?")) {
            pstmt.setString(1, name);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                task = new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("value"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch task", e);
        }
        return task;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks")) {
            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("value"),
                        resultSet.getString("description")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch tasks", e);
        }
        return tasks;
    }
}
