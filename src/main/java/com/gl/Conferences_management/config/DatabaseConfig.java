package com.gl.Conferences_management.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        dataSource.setDriverClassName(dbDriver);

        // Aggressive connection pool settings to prevent leaks
        dataSource.setMaximumPoolSize(3);
        dataSource.setMinimumIdle(1);
        dataSource.setConnectionTimeout(30000);
        dataSource.setIdleTimeout(600000);
        dataSource.setMaxLifetime(1800000);
        dataSource.setLeakDetectionThreshold(30000);
        dataSource.setConnectionTestQuery("SELECT 1");
        dataSource.setKeepaliveTime(60000);

        // Additional settings to prevent connection storms
        dataSource.setValidationTimeout(5000);
        dataSource.setInitializationFailTimeout(0);
        dataSource.setIsolateInternalQueries(false);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * Utility method to safely execute database operations with retry logic
     */
    public static <T> T executeWithRetry(DatabaseOperation<T> operation, int maxRetries) throws SQLException {
        SQLException lastException = null;
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                return operation.execute();
            } catch (SQLException e) {
                lastException = e;
                if (attempt < maxRetries) {
                    try {
                        // Exponential backoff: wait 100ms * attempt number
                        Thread.sleep(100 * attempt);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new SQLException("Interrupted during retry", ie);
                    }
                }
            }
        }
        throw lastException;
    }

    @FunctionalInterface
    public interface DatabaseOperation<T> {
        T execute() throws SQLException;
    }
}