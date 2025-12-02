package com.gl.Conferences_management.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gl.Conferences_management.config.DatabaseConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Execute a query with retry logic and proper connection management
     */
    public List<Map<String, Object>> executeQuery(String sql, Object... args) {
        try {
            return DatabaseConfig.executeWithRetry(() -> {
                log.debug("Executing query: {}", sql);
                List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, args);
                log.debug("Query executed successfully, returned {} rows", result.size());
                return result;
            }, 3);
        } catch (SQLException e) {
            log.error("Database query failed after retries: {}", sql, e);
            throw new RuntimeException("Database operation failed", e);
        } catch (DataAccessException e) {
            log.error("Data access error for query: {}", sql, e);
            throw new RuntimeException("Database access error", e);
        }
    }

    /**
     * Execute a query with retry logic (no parameters)
     */
    public List<Map<String, Object>> executeQuery(String sql) {
        return executeQuery(sql, new Object[0]);
    }

    /**
     * Execute an update operation with retry logic
     */
    public int executeUpdate(String sql, Object... args) {
        try {
            return DatabaseConfig.executeWithRetry(() -> {
                log.debug("Executing update: {}", sql);
                int result = jdbcTemplate.update(sql, args);
                log.debug("Update executed successfully, affected {} rows", result);
                return result;
            }, 3);
        } catch (SQLException e) {
            log.error("Database update failed after retries: {}", sql, e);
            throw new RuntimeException("Database update failed", e);
        } catch (DataAccessException e) {
            log.error("Data access error for update: {}", sql, e);
            throw new RuntimeException("Database access error", e);
        }
    }

    /**
     * Get a single result with retry logic
     */
    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args) {
        try {
            return DatabaseConfig.executeWithRetry(() -> {
                log.debug("Executing query for object: {}", sql);
                T result = jdbcTemplate.queryForObject(sql, requiredType, args);
                log.debug("Query for object executed successfully");
                return result;
            }, 3);
        } catch (SQLException e) {
            log.error("Database query for object failed after retries: {}", sql, e);
            throw new RuntimeException("Database operation failed", e);
        } catch (DataAccessException e) {
            log.error("Data access error for query: {}", sql, e);
            throw new RuntimeException("Database access error", e);
        }
    }

    /**
     * Check database connectivity
     */
    public boolean isDatabaseAvailable() {
        try {
            executeQuery("SELECT 1");
            return true;
        } catch (Exception e) {
            log.error("Database connectivity check failed", e);
            return false;
        }
    }
}