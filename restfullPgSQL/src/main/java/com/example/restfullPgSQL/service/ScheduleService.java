package com.example.restfullPgSQL.service;

import com.example.restfullPgSQL.model.Schedule;
import com.example.restfullPgSQL.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleByCityFromId(int from){
        return scheduleRepository.findByCityFromId(from);
    }

    public List<Schedule> getScheduleByCityToId(int to){
        return scheduleRepository.findByCityToId(to);
    }

    public List<Schedule> getScheduleByTrainId(int trainId){
        return scheduleRepository.findByTrainId(trainId);
    }

    public List<Schedule> getScheduleByStartTime(LocalDateTime startTime){
        return scheduleRepository.findByStartTime(startTime);
    }

    public List<Schedule> getScheduleByEndTime(LocalDateTime endTime){
        return scheduleRepository.findByEndTime(endTime);
    }

    public void saveSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Integer id){
        scheduleRepository.deleteById(id);
    }

    public Schedule getScheduleById(Integer id){
        return scheduleRepository.findById(id).orElse(null);
    }
}
