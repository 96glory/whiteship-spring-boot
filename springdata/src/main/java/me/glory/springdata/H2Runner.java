package me.glory.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 새로운 connection
        Connection connection = dataSource.getConnection();
        // metadata 출력
        System.out.println(connection.getMetaData().getURL());
        System.out.println(connection.getMetaData().getUserName());

        // user라는 테이블 만들기
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
        statement.executeUpdate(sql);

        // record 삽입
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'glory')");

        connection.close();
    }

}
