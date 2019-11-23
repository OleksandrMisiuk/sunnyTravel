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
        return this.jdbcTemplate.query(order, this.tourMapper);
    }

    @Override
    public TourDto getPackage(BookDto bookDto) {
        return this.jdbcTemplate.queryForObject(Query.QUERY_GET_PACKAGE, this.tourMapper, bookDto.getPackageId(),
                bookDto.getRoomId(), bookDto.getMealId());
    }
}
