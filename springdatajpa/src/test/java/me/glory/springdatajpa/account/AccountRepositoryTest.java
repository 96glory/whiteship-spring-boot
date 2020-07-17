package me.glory.springdatajpa.account;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di(){
        try(Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Test
    public void di2(){
        Account account = new Account();
        account.setUsername("glory");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

//        Optional<> 사용 전
//        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
//        assertThat(existingAccount).isNotNull();
//
//        Account nonexistentAccount = accountRepository.findByUsername("nothing");
//        assertThat(nonexistentAccount).isNull();

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotEmpty();

        Optional<Account> nonexistentAccount = accountRepository.findByUsername("nothing");
        assertThat(nonexistentAccount).isEmpty();
    }

}