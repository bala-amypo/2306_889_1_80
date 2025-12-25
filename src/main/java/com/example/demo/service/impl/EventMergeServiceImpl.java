// src/main/java/com/example/demo/service/impl/EventMergeServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AcademicEventRepository;
import com.example.demo.repository.EventMergeRecordRepository;
import com.example.demo.service.EventMergeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMergeServiceImpl implements EventMergeService {

    private final EventMergeRecordRepository repository;
    private final AcademicEventRepository eventRepository;

    public EventMergeServiceImpl(EventMergeRecordRepository repository, AcademicEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventMergeRecord mergeEvents(List<Long> eventIds, String reason) {
        List<AcademicEvent> events = eventRepository.findAllById(eventIds);
        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No events found");
        }
        String sourceEventIdsStr = eventIds.stream().map(String::valueOf).collect(Collectors.joining(","));
        LocalDate minStart = events.stream().map(AcademicEvent::getStartDate).min(LocalDate::compareTo).get();
        LocalDate maxEnd = events.stream().map(AcademicEvent::getEndDate).max(LocalDate::compareTo).get();
        String mergedTitle = "Merged Event";
        EventMergeRecord record = new EventMergeRecord(null, sourceEventIdsStr, mergedTitle, minStart, maxEnd, reason, null);
        return repository.save(record);
    }

    @Override
    public List<EventMergeRecord> getAllMergeRecords() {
        return repository.findAll();
    }

    @Override
    public EventMergeRecord getMergeRecordById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merge record not found"));
    }

    @Override
    public List<EventMergeRecord> getMergeRecordsByDate(LocalDate start, LocalDate end) {
        return repository.findByMergedStartDateBetween(start, end);
    }
}