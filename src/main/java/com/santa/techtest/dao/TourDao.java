package com.santa.techtest.dao;

import com.santa.techtest.dto.TourDto;

import java.util.List;

public interface TourDao {
    List<TourDto> filterPackages(String order);
}
