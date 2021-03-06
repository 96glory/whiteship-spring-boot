package me.glory.springsecurity2;

import me.glory.springsecurity2.account.Account;
import me.glory.springsecurity2.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
    
    @Autowired
    AccountService accountService;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account glory = accountService.createAccount("glory", "1234");
        System.out.println(glory.getUsername() + " password: " + glory.getPassword());
    }
}
