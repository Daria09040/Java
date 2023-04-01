package com.example.restfullPgSQL.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name="schedule")
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="cityFrom", nullable = false)
    private City cityFrom;

    @ManyToOne
    @JoinColumn(name="cityTo", nullable = false)
    private City cityTo;

    @ManyToOne
    @JoinColumn(name="trainId", nullable = false)
    private Train train;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime startTime, endTime;

    public void updateSchedule(Schedule schedule){
        if(schedule.train != null){
            this.train = schedule.train;
        }
        if(schedule.cityFrom != null){
            this.cityFrom = schedule.cityFrom;
        }
        if(schedule.cityTo != null){
            this.cityTo = schedule.cityTo;
        }
        if(schedule.startTime != null){
            this.startTime = schedule.startTime;
        }
        if(schedule.endTime != null){
            this.endTime = schedule.endTime;
        }
    }

}
