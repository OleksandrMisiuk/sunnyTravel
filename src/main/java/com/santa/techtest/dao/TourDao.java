package com.santa.techtest.dao;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;

import java.util.List;

public interface TourDao {
    List<TourDto> filterPackages(String order);
    TourDto getPackage(BookDto bookDto);
    TourDto getPackageByUserId(String username);
    boolean setTour(BookDto bookDto);
    Long getTourId(BookDto bookDto);
    boolean removeTour(Long id);
    Long getTourIdByUsername(String username);
}
