package com.santa.techtest.controller;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;
import com.santa.techtest.model.Bill;
import com.santa.techtest.service.CounterService;
import com.santa.techtest.service.EmailService;
import com.santa.techtest.service.TourService;
import com.santa.techtest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/packages")
public class MainController {

    private TourService tourService;
    private CounterService counterService;
    private EmailService emailService;
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    public MainController(TourService tourService, CounterService counterService, EmailService emailService, UserService userService) {
        this.tourService = tourService;
        this.counterService = counterService;
        this.emailService = emailService;
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<TourDto> filterPackages(@RequestBody TourDto filterDto){
        return tourService.filterPackages(filterDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/preOrder", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Bill preOrderPackage(@RequestBody BookDto bookDto){
        return counterService.getBill(bookDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean orderPackage(@RequestBody BookDto bookDto, Authentication authentication)
    {
        TourDto tourDto = tourService.getPackage(bookDto);
        Bill bill = counterService.getBill(bookDto);
        logger.info("Main controller order method name: " + authentication.getName());
        emailService.sendSimpleMessage("SunnyTravel: Package ordered",
                "////////////////Tour/////////////// \n" + tourDto.toEmail() +
                        "///////////////Bill/////////////// \n" + bill.toEmail() + '\n' +
                "Pay for a package to this account: 5648 8789 7874 5458", authentication.getName());
        return userService.setTour(authentication.getName(), bookDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/getTour", consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TourDto getUsersTour(@RequestBody String username){
        return userService.getTour(username);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/removeTour", consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean removeUsersTour(@RequestBody String username){
        return userService.removeTour(username);
    }
}
