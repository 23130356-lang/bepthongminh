package com.example.Webbepthongminh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class DatabaseCheck implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(" KẾT NỐI THÀNH CÔNG!");
            System.out.println(" Database URL: " + connection.getMetaData().getURL());
            System.out.println(" User: " + connection.getMetaData().getUserName());
        } catch (Exception e) {
            System.out.println(" KẾT NỐI THẤT BẠI!");
            System.out.println(" Lỗi: " + e.getMessage());
        }
    }
}