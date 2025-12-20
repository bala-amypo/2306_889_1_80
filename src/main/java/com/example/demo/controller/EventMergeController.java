package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merges")
public class EventMergeController {

    private final EventMergeService mergeService;

    public EventMergeController(EventMergeService mergeService) {
        this.mergeService = mergeService;
    }

    @PostMapping
    public EventMergeRecord merge(@RequestBody EventMergeRecord record) {
        return mergeService.mergeEvents(record);
    }

    @GetMapping
    public List<EventMergeRecord> getAll() {
        return mergeService.getAllMerges();
    }
}
