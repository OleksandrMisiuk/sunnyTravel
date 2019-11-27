package com.santa.techtest.dao;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;
import com.santa.techtest.mapper.TourMapper;
import com.santa.techtest.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);
    private TourMapper tourMapper;

    @Autowired
    public TourDaoImpl(DataSource dataSource, TourMapper tourMapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.tourMapper = tourMapper;
    }

    @Override
    public List<TourDto> filterPackages(String order) {
        try {
            return this.jdbcTemplate.query(order, this.tourMapper);
        }catch (Exception e){
            logger.error("Filter packages method error: " + e.getMessage());
            throw new RuntimeException("Filter packages method error: " + e.getMessage());
        }
    }

    @Override
    public TourDto getPackage(BookDto bookDto) {
        try {
            return this.jdbcTemplate.queryForObject(Query.QUERY_GET_PACKAGE, this.tourMapper, bookDto.getPackageId(),
                    bookDto.getRoomId(), bookDto.getMealId());
        }catch (Exception e){
            logger.error("Get package method error" + e.getMessage());
            throw new RuntimeException("Get package method error" + e.getMessage());
        }

    }

    @Override
    public TourDto getPackageByUserId(String username) {
        try {
            return this.jdbcTemplate.queryForObject(Query.SQL_GET_PACKAGE_BY_USERNAME, this.tourMapper, username);
        }catch (Exception e){
            logger.error("Get package by user_id method error: " + e.getMessage());
            throw new RuntimeException("Get package by user_id method error: " + e.getMessage());
        }
    }

    @Override
    public boolean setTour(BookDto bookDto) {
        try {
            return this.jdbcTemplate.update(Query.SQL_SET_USERS_PACKAGES,
                    bookDto.getPackageId(), bookDto.getRoomId(), bookDto.getMealId())>0;
        }catch (Exception e){
            logger.error("Set tour method error: " + e.getMessage());
            throw new RuntimeException("Set tour method error: " + e.getMessage());
        }
    }

    @Override
    public Long getTourId(BookDto bookDto) {
        try {
            return this.jdbcTemplate.queryForObject(Query.SQL_GET_USERS_PACKAGE_ID, Long.class,
                    bookDto.getPackageId(), bookDto.getRoomId(), bookDto.getMealId());
        }catch (Exception e){
            logger.error("Get tour id method error: " + e.getMessage());
            throw new RuntimeException("Get tour id method error: " + e.getMessage());
        }
    }

    @Override
    public boolean removeTour(Long id) {
        try {
            return this.jdbcTemplate.update(Query.SQL_REMOVE_USERS_PACKAGE, id)>0;
        }catch (Exception e){
            logger.error("Remove tour method error: " + e.getMessage());
            throw new RuntimeException("Remove tour method error: " + e.getMessage());
        }
    }

    @Override
    public Long getTourIdByUsername(String username) {
        try {
            return this.jdbcTemplate.queryForObject(Query.SQL_GET_USER_PACKAGE_ID_BY_USERNAME, Long.class,
                    username);
        }catch (Exception e){
            logger.error("Get tour id by username method error: " + e.getMessage());
            throw new RuntimeException("Get tour id by username method error: " + e.getMessage());
        }
    }
}
