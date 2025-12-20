public interface EventMergeRecordRepository extends JpaRepository<EventMergeRecord, Long> {
    List<EventMergeRecord> findByMergedStartDateBetween(LocalDate start, LocalDate end);
}
package com.example.demo.repository;

import com.example.demo.entity.EventMergeReord;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventMergeReordRepository extends JpaRepository<EventMergeReord, Long> {

    List<AcademicEvent> findByEventName(String eventName);
}
