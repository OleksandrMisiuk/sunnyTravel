package com.santa.techtest.mapper;

import com.santa.techtest.model.Counter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class CounterMapper implements RowMapper<Counter> {

    @Override
    public Counter mapRow(ResultSet resultSet, int i) throws SQLException {
        Counter counter = new Counter();
        counter.setDateDepart(resultSet.getObject("date_depart", LocalDate.class));
        counter.setDuration(resultSet.getInt("duration"));
        counter.setHotelPriceType(resultSet.getString("hotel_price_type"));
        counter.setInsurance(resultSet.getBoolean("insurance"));
        counter.setMealPrice(resultSet.getLong("meal_price"));
        counter.setNumberOfPeople(resultSet.getInt("seats"));
        counter.setPackagePrice(resultSet.getLong("package_price"));
        counter.setPackagePriceType(resultSet.getString("package_price_type"));
        counter.setRoomPrice(resultSet.getLong("room_price"));
        counter.setTransfer(resultSet.getBoolean("transfer"));
        counter.setVisaFee(resultSet.getLong("visafee"));
        counter.setVisaFeeTypePrice(resultSet.getString("country_price_type"));
        counter.setEu(resultSet.getBoolean("eu"));
        return counter;
    }
}
