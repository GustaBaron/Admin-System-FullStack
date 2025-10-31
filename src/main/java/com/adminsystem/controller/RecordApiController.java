package com.adminsystem.controller;

import com.adminsystem.entity.Record;
import com.adminsystem.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records") // O prefixo da nossa API
public class RecordApiController {

    @Autowired
    private RecordService recordService;


    @GetMapping
    public List<Record> getAllRecords() {
        return recordService.findAll();
    }


    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return recordService.save(record);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Record> updateRecord(@PathVariable Long id, @RequestBody Record recordDetails) {
        Record updatedRecord = recordService.update(id, recordDetails);
        if (updatedRecord == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRecord);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        recordService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}