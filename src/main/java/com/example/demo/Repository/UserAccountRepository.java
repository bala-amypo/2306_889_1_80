package com.example.demo.repository;
import org.springframework.data.Jpa.repository.JpaRepository;
import com.example.demo.entity.UserAccountRepository;
public interface UserAccountRepository extends JpaRepository<UserAccount,Long>{
    
}