package com.santa.techtest.dao;

import com.santa.techtest.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CurrencyDaoImpl.class);

    @Autowired
    public CurrencyDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public float getValue(String name) {
        return this.jdbcTemplate.queryForObject(Query.QUERY_GET_CURRENCY_VALUE, Float.class, name);
    }

    @Override
    public boolean setValue(float value, String name) {
        return this.jdbcTemplate.update(Query.QUERY_SET_CURRENCY_VALUE, value, name)==1?true:false;
    }
}
