package com.example.bookingsBackend.service;

import com.example.bookingsBackend.model.AdditionalService;
import com.example.bookingsBackend.repository.AdditionalServiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdditionalServiceService {
    @Autowired
    private AdditionalServiceRepository additionalServiceRepository;

    public List<AdditionalService> getAllAdditionalServices(){
        return additionalServiceRepository.findAll();
    }

    public List<AdditionalService> getAdditionalServiceByName(String name){
        return additionalServiceRepository.findByName(name);
    }

    public List<AdditionalService> getAdditionalServiceByPricePerDay(Double pricePerDay){
        return additionalServiceRepository.findByPricePerDay(pricePerDay);
    }

    public void saveAdditionalService(AdditionalService additionalService){
        additionalServiceRepository.save(additionalService);
    }

    public void deleteAdditionalService(Integer id){
        additionalServiceRepository.deleteById(id);
    }

    public AdditionalService getAdditionalServiceById(Integer id){
        return additionalServiceRepository.findById(id).orElse(null);
    }
}
