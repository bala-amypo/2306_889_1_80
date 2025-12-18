package com.example.demo.repository;
import org.springframework.data.Jpa.repository.JpaRepository;
import com.example.demo.entity.HarmonizedCalendarRepository;
public interface HarmonizedCalendarRepository extends JpaRepository<EventMergeRecordHarmonizedCalendar,Long>{
    
}