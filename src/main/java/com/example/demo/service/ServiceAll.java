package com.example.demo.service;

import com.example.demo.repository.RepositoryAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ServiceAll {

    @Autowired
    private RepositoryAll repositoryAll;

    public List<Map<String, Object>> getAllNameDB() {
        return repositoryAll.getAllNameDB();
    }

    public List<Map<String, Object>> getAllNameTBofDB(String nameDB) {
        return repositoryAll.getAllNameTBofDB(nameDB);
    }

    public List<Map<String, Object>> getDataTB (String nameDB, String nameTB){
        return repositoryAll.getDataTB(nameDB,nameTB);
    }

    public List<Map<String, Object>> getDataTB (String nameDB, String nameTB, String isASC, String limit){
        return repositoryAll.getDataTB(nameDB,nameTB, isASC, limit);
    }

    public List<Map<String, Object>> getDescribeTB (String nameDB, String nameTB){
        return repositoryAll.getDescribeTB(nameDB,nameTB);
    }
}
