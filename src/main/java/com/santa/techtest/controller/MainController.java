package com.santa.techtest.controller;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;
import com.santa.techtest.model.Bill;
import com.santa.techtest.service.CounterService;
import com.santa.techtest.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class MainController {

    private TourService tourService;
    private CounterService counterService;

    @Autowired
    public MainController(TourService tourService, CounterService counterService) {
        this.tourService = tourService;
        this.counterService = counterService;
    }

//    @PreAuthorize("hasRole(ADMIN)")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TourDto> filterPackages(@RequestBody TourDto filterDto){
        return tourService.filterPackages(filterDto);
    }

    @PreAuthorize("hasAnyRole(ROLE_ADMIN,ROLE_USER)")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/preOrder", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bill orderPackage(@RequestBody BookDto bookDto){
        return counterService.getBill(bookDto);
    }
}
