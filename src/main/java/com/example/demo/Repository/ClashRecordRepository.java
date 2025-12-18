package com.example.demo.repository;
import org.springframework.data.Jpa.repository.JpaRepository;
import com.example.demo.entity.ClashRecordRepository;
public interface ClashRecordRepository extends JpaRepository<ClashRecord,Long>{
    
}