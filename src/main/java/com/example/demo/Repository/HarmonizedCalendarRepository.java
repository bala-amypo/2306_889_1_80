package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.HarmonizedRecord;

public interface HarmonizedRecordRepository extends JpaRepository<HarmonizedRecord, Long> {

}
