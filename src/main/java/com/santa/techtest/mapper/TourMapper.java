package com.santa.techtest.mapper;

import com.santa.techtest.dto.TourDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class TourMapper implements RowMapper<TourDto> {
    @Override
    public TourDto mapRow(ResultSet resultSet, int i) throws SQLException {
        TourDto tourDto = new TourDto();
        tourDto.setPackageId(resultSet.getLong("package_id"));
        tourDto.setMealId(resultSet.getLong("meal_id"));
        tourDto.setRoomId(resultSet.getLong("room_id"));
        tourDto.setCountry(resultSet.getString("country_name"));
        tourDto.setCity(resultSet.getString("city_name"));
        tourDto.setHotel(resultSet.getString("hotel_name"));
        tourDto.setDateDepart(resultSet.getObject("date_depart", LocalDate.class));
        tourDto.setDuration(resultSet.getInt("duration"));
        tourDto.setDescription(resultSet.getString("desc"));
        tourDto.setNumberOfPeople(resultSet.getInt("seats"));
        tourDto.setSeaDistance(resultSet.getInt("sea_distance"));
        tourDto.setRoomType(resultSet.getString("room_type"));
        tourDto.setMeal(resultSet.getString("meal_type"));
        tourDto.setHotelRating(resultSet.getInt("rating"));
        tourDto.setTransfer(resultSet.getBoolean("transfer"));
        tourDto.setInsurance(resultSet.getBoolean("insurance"));
        tourDto.setVisa(resultSet.getBoolean("visa"));
        return tourDto;
    }
}
