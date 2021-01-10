package com.harilab.clinic.controller;

import com.harilab.clinic.model.Record;
import com.harilab.clinic.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping("/participants/{pid}/records")
    @CrossOrigin
    public Record addRecord(@PathVariable int pid, @RequestBody Record record) {
        return service.saveRecord(pid, record);
    }

    @CrossOrigin
    @GetMapping("/records/{id}")
    public Record getRecordById(@PathVariable int id){
        return service.getRecordById(id);
    }

    @CrossOrigin
    @GetMapping("/participants/{pid}/records")
    public List<Record> getRecordsByParticipant(@PathVariable int pid){
        return service.getRecordsByParticipant(pid);
    }

    @CrossOrigin
    @GetMapping("/participants/{pid}/records/latest")
    public Record getLatestRecordByParticipant(@PathVariable int pid){
        return service.getLatestRecordByParticipant(pid);
    }

    @CrossOrigin
    @GetMapping("/participants/{pid}/usage/lastweek")
    public int[] getWeeklyUsageByParticipant(@PathVariable int pid){
        return service.getWeeklyUsageByParticipant(pid);
    }

    @CrossOrigin
    @GetMapping("/participants/{pid}/records/today")
    public List<Record> getTodayRecordsByParticipant(@PathVariable int pid){
        return service.getTodayRecordsByParticipant(pid);
    }

    @CrossOrigin
    @PatchMapping("/records")
    public Record updateRecord(@RequestBody Record record) {
        return service.updateRecord(record);
    }

    @CrossOrigin
    @DeleteMapping("/records/{id}")
    public String deleteRecord(@PathVariable int id) {
        return service.deleteRecordById(id);
    }

}
