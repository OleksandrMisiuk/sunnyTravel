package com.santa.techtest.service;

import com.santa.techtest.dao.TourDao;
import com.santa.techtest.dto.BookDto;
import com.santa.techtest.dto.TourDto;
import com.santa.techtest.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private TourDao tourDao;
    @Autowired
    public TourServiceImpl(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    @Override
    public List<TourDto> filterPackages(TourDto order) {
        StringBuilder queryOrder = new StringBuilder(Query.QUERY_FOR_ORDER);
        if(!order.getCountry().isEmpty()){
            queryOrder.append("AND country.name like '").append(order.getCountry()).append("%' ");
        }
        if(!order.getCity().isEmpty()){
            queryOrder.append("AND city.name like '").append(order.getCity()).append("%' ");
        }
        if(order.getDateDepart()!=null){
            queryOrder.append("AND package.date_depart = '").append(order.getDateDepart()).append("' ");
        }
        if(order.getNumberOfPeople()>0){
            queryOrder.append("AND room.seats = '").append(order.getNumberOfPeople()).append("' ");
        }
        if(order.getSeaDistance()>0){
            queryOrder.append("AND hotel.sea_distance = '").append(order.getSeaDistance()).append("' ");
        }
        if(!order.getRoomType().isEmpty()){
            queryOrder.append("AND room.type like '").append(order.getRoomType()).append("%' ");
        }
        if(!order.getMeal().isEmpty()) {
            queryOrder.append("AND meal.type like '").append(order.getMeal()).append("%' ");
        }
        if(order.getHotelRating()>0){
            queryOrder.append("AND hotel.rating = '").append(order.getHotelRating()).append("' ");
        }
        if(order.isInsurance()){
            queryOrder.append("AND package.insurance = '").append(order.isInsurance()).append("' ");
        }
        if(order.isTransfer()){
            queryOrder.append("AND package.transfer = '").append(order.isTransfer()).append("' ");
        }
        if(order.isVisa()){
            queryOrder.append("AND package.visa = '").append(order.isVisa()).append("' ");
        }
        if(order.getDuration()>0){
            queryOrder.append("AND package.duration = '").append(order.getDuration()).append("' ");
        }
        queryOrder.append(";");
        return tourDao.filterPackages(queryOrder.toString());
    }

    @Override
    public TourDto getPackage(BookDto bookDto) {
        return tourDao.getPackage(bookDto);
    }
}
