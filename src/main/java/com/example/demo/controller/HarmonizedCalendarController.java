package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService calendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping
    public HarmonizedCalendar generate(@RequestBody HarmonizedCalendar calendar) {
        return calendarService.generateCalendar(calendar);
    }

    @GetMapping("/active")
    public List<HarmonizedCalendar> getActive(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return calendarService.getActiveCalendars(from, to);
    }
}
