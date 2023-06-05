package com.example.tripsBackend.service;

import com.example.tripsBackend.model.TrainType;
import com.example.tripsBackend.repository.TrainTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TrainTypeService {
    @Autowired
    private TrainTypeRepository trainTypeRepository;

    public List<TrainType> getAllTrainTypes(){
        return trainTypeRepository.findAll();
    }

    public List<TrainType> getTrainTypeByName(String name){
        return trainTypeRepository.findByName(name);
    }

    public void saveTrainType(TrainType trainType){
        trainTypeRepository.save(trainType);
    }

    public void deleteTrainType(Integer id){
        trainTypeRepository.deleteById(id);
    }

    public TrainType getTrainTypeById(Integer id){
        return trainTypeRepository.findById(id).orElse(null);
    }
}
