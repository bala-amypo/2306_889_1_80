package com.example.demo.repository;
import org.springframework.data.Jpa.repository.JpaRepository;
import com.example.demo.entity.EventMergeRecordRepository;
public interface EventMergeRecordRepository extends JpaRepository<EventMergeRecord,Long>{
    
}