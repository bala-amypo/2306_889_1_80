package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashRecordService clashService;

    public ClashRecordController(ClashRecordService clashService) {
        this.clashService = clashService;
    }

    @GetMapping("/unresolved")
    public List<ClashRecord> getUnresolved() {
        return clashService.getUnresolvedClashes();
    }

    @PutMapping("/{id}/resolve")
    public ClashRecord resolve(@PathVariable Long id) {
        return clashService.resolveClash(id);
    }
}
