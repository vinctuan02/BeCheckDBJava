package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class RepositoryAll {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getAllNameDB () {
        String sql = "SHOW DATABASES";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    public List<Map<String, Object>> getAllNameTBofDB (String nameDB) {
        String sql = "SHOW TABLES FROM " + nameDB;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    public List<Map<String, Object>> getDataTB (String nameDB, String nameTB) {
        String sql = "SELECT * FROM " + nameDB + "." + nameTB;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    public List<Map<String, Object>> getDataTB (String nameDB, String nameTB, String isASC, String limit) {
        String ASC_or_DESC = (Objects.equals(isASC, "true")) ? "ASC" : "DESC";
        String sql = "SELECT * FROM " + nameDB + "." + nameTB + " ORDER BY id " + ASC_or_DESC + " LIMIT " + limit;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

    public List<Map<String, Object>> getDescribeTB (String nameDB, String nameTB) {
        String sql = "DESCRIBE " + nameDB + "." + nameTB;
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        return result;
    }

}
