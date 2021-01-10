package com.harilab.clinic.service;

import com.harilab.clinic.model.Participant;
import com.harilab.clinic.model.Record;
import com.harilab.clinic.repository.ParticipantRepository;
import com.harilab.clinic.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RecordService {


    @Autowired
    private RecordRepository repository;

    @Autowired
    private ParticipantRepository participantRepository;

    // create record
    public Record saveRecord(int pid, Record record) {
        Participant participant = participantRepository.findById(pid).orElse(null);
        if (participant == null) {
            // To do : throw exception
            return null;
        }
        // update last_record_time
        if(participant.getLast_record_time() == null || record.getTime() == null){
            System.out.println("null timestamp !");
        }
        if (participant.getLast_record_time().compareTo(record.getTime()) < 0) {
            participant.setLast_record_time(record.getTime());
        }

        record.setParticipant(participant);
        return repository.save(record);
    }

    // get record
    public List<Record> getAllRecords() {
        return repository.findAll();
    }

    public List<Record> getRecordsByParticipant(int pid) {
        Participant participant = participantRepository.findById(pid).orElse(null);
        if (participant == null) {
            // To do : throw exception
            return null;
        }
        List<Record> result = participant.getRecords();
        result.sort(new CompareByTime());
        return result;
    }

    public int[] getWeeklyUsageByParticipant(int pid) {
        int[] result = new int[7];
        List<Integer> counts = repository.getWeeklyRecords(pid);
        int start = 0;
        for (Integer i : counts) {
            result[start++] = i;
        }
        return result;
    }

    public List<Record> getTodayRecordsByParticipant(int pid) {
        return repository.getTodayRecords(pid);
    }

    public Record getLatestRecordByParticipant(int pid) {
        Participant participant = participantRepository.findById(pid).orElse(null);
        if (participant == null) {
            // To do : throw exception
            return null;
        }
        List<Record> records = participant.getRecords();

        if (records == null || records.size() == 0) {
            // to do : throw exception
            return null;
        }
        records.sort(new CompareByTime());
        return records.get(0);
    }


    // delete record
    public String deleteRecordById(int id) {
        repository.deleteById(id);
        return "Record removed !!" + id;
    }

    // update record
    public Record updateRecord(Record record) {
        Record existingRecord = repository.findById(record.getId()).orElse(null);
        existingRecord.setTime(record.getTime());
        existingRecord.setLocation(record.getLocation());
        return repository.save(existingRecord);
    }

    public Record getRecordById(int id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Comparator class used to sort record in reversed time order.
     */
    private class CompareByTime implements Comparator<Record> {
        public int compare(Record one, Record two) {
            return two.getTime().compareTo(one.getTime());
        }
    }

}

