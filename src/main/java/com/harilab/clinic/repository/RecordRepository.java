package com.harilab.clinic.repository;

import com.harilab.clinic.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {
    @Query(value = "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -7 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -6 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -6 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -5 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -5 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -4 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -4 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -3 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -3 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -2 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -2 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL -1 DAY)" + "UNION ALL " +
            "SELECT COUNT(*) from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -1 DAY) and record.time < DATE_ADD(CURDATE(),INTERVAL 0 DAY)", nativeQuery = true)
    List<Integer> getWeeklyRecords(int pid);

    @Query(value = "SELECT * from record where participant_id = ?1 and record.time >= DATE_ADD(CURDATE(),INTERVAL -1 DAY)", nativeQuery = true)
    List<Record> getTodayRecords(int pid);

}
