package com.example.restfullPgSQL.service;

import com.example.restfullPgSQL.model.Type;
import com.example.restfullPgSQL.repository.TypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }

    public List<Type> getTypeByName(String name){
        return typeRepository.findByName(name);
    }

    public void saveType(Type type){
        typeRepository.save(type);
    }

    public void deleteType(Integer id){
        typeRepository.deleteById(id);
    }

    public Type getTypeById(Integer id){
        return typeRepository.findById(id).orElse(null);
    }
}
