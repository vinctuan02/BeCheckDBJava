package com.example.demo.controller;

import com.example.demo.model.ApiRespone;
import com.example.demo.service.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ControllerAll {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAll.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ServiceAll serviceAll;

    @GetMapping("/get-all-name-db")
    public ApiRespone getAllDatabases() {
        List<Map<String, Object>> data = serviceAll.getAllNameDB();
        return new ApiRespone<>("Get all name db oke", "Oke", data);
    }

    @GetMapping("/get-all-name-tb-of-db")
    public ApiRespone getAllTablesOfDB(@RequestParam String nameDB) {
        List<Map<String, Object>> data = serviceAll.getAllNameTBofDB(nameDB);
        return new ApiRespone<>("Get all name table of db oke", "Oke", data);
    }


    @GetMapping("/get-data-tb")
    public ApiRespone getDataTB(
            @RequestParam String nameDB,
            @RequestParam String nameTB,
            @RequestParam(required = false) String isASC,
            @RequestParam(required = false) String limit) {

        if (isASC != null && limit != null) {
            List<Map<String, Object>> data = serviceAll.getDataTB(nameDB, nameTB, isASC, limit);
            return new ApiRespone<>("Get data table of db oke", "Oke", data);
        } else {
            List<Map<String, Object>> data = serviceAll.getDataTB(nameDB, nameTB);
            return new ApiRespone<>("Get data table of db oke", "Oke", data);
        }


    }


    @GetMapping("/get-describe-tb")
    public ApiRespone getDescribeTB(@RequestParam String nameDB, String nameTB) {
        List<Map<String, Object>> data = serviceAll.getDescribeTB(nameDB, nameTB);
        return new ApiRespone<>("Get all name table of db oke", "Oke", data);
    }

}

