public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
    boolean existsByEmail(String email);
}
public interface EventMergeRecordRepository extends JpaRepository<EventMergeRecord, Long> {
    List<EventMergeRecord> findByMergedStartDateBetween(LocalDate start, LocalDate end);
}
package com.example.demo.repository;

import com.example.demo.entity.UserAccount;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    List<AcademicEvent> findByEventName(String eventName);
}
