package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.EventMergeRecord;

public interface EventMergeService {

    EventMergeRecord mergeEvents(List<Long> eventIds, String reason);

    List<EventMergeRecord> getAllMergeRecords();

    EventMergeRecord getMergeRecordById(Long id);

    List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end);
}
