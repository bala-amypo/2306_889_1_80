package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EventMergeRecord;

public interface EventMergeRecordRecordRepository extends JpaRepository<EventMergeRecord, Long> {

}
