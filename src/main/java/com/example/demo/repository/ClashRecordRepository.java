package com.example.demo.repository;

import com.example.demo.entity.ClashRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClashRecordRepository extends JpaRepository<ClashRecord, Long> {
    
    // Find all clashes involving a specific event (checking both A and B sides)
    List<ClashRecord> findByEventAIdOrEventBId(Long eventAId, Long eventBId);
    
    // Get all clashes that are currently unresolved
    List<ClashRecord> findByResolvedFalse();
}