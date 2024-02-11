package com.rocketseat.certification_nlw.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateSeed {
    private final JdbcTemplate template;

    public CreateSeed(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/nlw");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        CreateSeed seed = new CreateSeed(dataSource);
        seed.run(args);
    }

    public void run(String[] args) {
        execSqlFile("src/main/resources/create.sql");
    }

    private void execSqlFile(String filePath) {
        try {
            String sql = new String(Files.readAllBytes(Paths.get(filePath)));
            template.execute(sql);
        } catch (IOException e) {
            System.err.println("Error reading SQL file");
            e.printStackTrace();
        }
    }
}
