package me.glory.springdatajpa.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository<Entity의 타입, Id의 타입>
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Optional<> 사용 전
    // Account findByUsername(String username);
    Optional<Account> findByUsername(String username);

}
