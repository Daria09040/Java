package com.example.testsPostgres.repository;

import com.example.testsPostgres.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = """
            SELECT * FROM public.schedule\s
            WHERE group_id IN (SELECT group_id FROM public.user WHERE row_id=:rowID)\s
            AND test_id NOT IN (SELECT test_id FROM public.student_answer WHERE user_id=:userID)
            """, nativeQuery=true)
    List<Schedule> findAllByRowIDAndUserID(Long rowID, Long userID);
}
