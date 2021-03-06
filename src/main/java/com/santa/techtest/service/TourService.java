package com.santa.techtest.service;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;

import java.util.List;

public interface TourService {
        List<TourDto> filterPackages(TourDto order);
        TourDto getPackage(BookDto bookDto);
}
