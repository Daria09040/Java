package com.example.restfullPgSQL.service;

import com.example.restfullPgSQL.model.Train;
import com.example.restfullPgSQL.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains(){
        return trainRepository.findAll();
    }

    public List<Train> getTrainByName(String name){
        return trainRepository.findByName(name);
    }

    public List<Train> getTrainByNumber(String number){
        return trainRepository.findByNumber(number);
    }

    public List<Train> getTrainByTypeId(int type){
        return trainRepository.findByTypeId(type);
    }

    public void saveTrain(Train train){
        trainRepository.save(train);
    }

    public void deleteTrain(Integer id){
        trainRepository.deleteById(id);
    }

    public Train getTrainById(Integer id){
        return trainRepository.findById(id).orElse(null);
    }
}
