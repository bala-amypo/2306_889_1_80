package com.example.demo.repository;
import org.springframework.data.Jpa.repository.JpaRepository;
import com.example.demo.entity.AcademicEventRepository;
public interface AcademicEventRepository extends JpaRepository<AcademicEvent,Long>{
    
}