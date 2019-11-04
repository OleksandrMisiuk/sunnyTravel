package com.santa.techtest.service;

import com.santa.techtest.dao.CounterDao;
import com.santa.techtest.dao.CurrencyDao;
import com.santa.techtest.dto.BookDto;
import com.santa.techtest.model.Bill;
import com.santa.techtest.model.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CounterServiceImpl implements CounterService{

    private CounterDao counterDao;
    private CurrencyDao currencyDao;
    private final float usd;
    private final float eur;
    private final float transfer = 20;
    private final float insurance = 200;
    private final float insuranceTwelve = 350;
    private final LocalDate independenceDay;
    private final LocalDate tourismDay;
    private static final Logger logger = LoggerFactory.getLogger(CounterServiceImpl.class);

    @Autowired
    public CounterServiceImpl(CounterDao counterDao, CurrencyDao currencyDao) {
        this.counterDao = counterDao;
        this.currencyDao = currencyDao;
        this.usd = currencyDao.getValue("USD");
        this.eur = currencyDao.getValue("EUR");
        independenceDay = LocalDate.of(0, 8, 24);
        tourismDay = LocalDate.of(0, 9, 27);
    }

    @Override
    public Bill getBill(BookDto bookDto) {
        Bill bill = new Bill();
        Counter counter = counterDao.getBill(bookDto);

        countPackagePrice(counter.getPackagePriceType(), counter.getPackagePrice(), counter.getNumberOfPeople(), bill);
        countTourFee(counter.getPackagePriceType(), counter.getPackagePrice(), bill);
        countMealPrice(counter.getHotelPriceType(), counter.getMealPrice(), counter.getNumberOfPeople(), bill);
        countRoomPrice(counter.getHotelPriceType(), counter.getRoomPrice(), bill);
        countVisaFee(counter.getVisaFeeTypePrice(), counter.getVisaFee(), bill);
        countTransfer(counter.isTransfer(), bill);
        countInsurance(counter.isInsurance(), counter.isEu(), counter.getDuration(), bill);
        sumDiscount(bill);
        dayDiscount(counter.getDateDepart(), bill);
        certificateDiscount(bookDto.getDiscountCode(), bill);
        return bill;
    }

    public void countPackagePrice(String packagePriceType, float packagePrice, int peopleNum, Bill bill){
        float tempCount = exchanger(packagePriceType, packagePrice);
        logger.info("Package price: " + packagePrice + " " + packagePriceType);
        tempCount *= peopleNum;
        bill.setPackagePrice(tempCount);
        bill.setTotal(bill.getTotal() + tempCount);
        logger.info("Package price: " + tempCount + " UAH added bill");
    }

    public void countTourFee(String packagePriceType, float packagePrice, Bill bill){
        float tempCount = exchanger(packagePriceType, packagePrice);
        bill.setTourFee(tempCount*0.05f);
        bill.setTotal(bill.getTotal() + tempCount*0.05f);
        logger.info("Tour fee: " + tempCount + "*0.05 = " + tempCount*0.05 + "UAH added to bill");
    }

    public void countMealPrice(String hotelPriceType, float mealPrice, int people, Bill bill){
        float tempCount = exchanger(hotelPriceType, mealPrice);
        logger.info("Meal price: " + mealPrice + " " + hotelPriceType);
        tempCount *= people;
        bill.setMealPrice(tempCount);
        bill.setTotal(bill.getTotal() + tempCount);
        logger.info("Meal price for " + people + " people = " + tempCount + "UAH added to bill");
    }

    public void countRoomPrice(String hotelPriceType, float roomPrice, Bill bill){
        float tempCount = exchanger(hotelPriceType, roomPrice);
        logger.info("Room price: " + roomPrice + " " + hotelPriceType);
        bill.setRoomPrice(tempCount);
        bill.setTotal(bill.getTotal() + tempCount);
        logger.info("Room price = " + tempCount + " UAH added to bill");
    }

    public void countVisaFee(String countryPriceType, float visafee, Bill bill){
        float tempCount = exchanger(countryPriceType, visafee);
        logger.info("Visa fee: " + visafee + " " + countryPriceType);
        bill.setVisafee(tempCount);
        bill.setTotal(bill.getTotal() + tempCount);
        logger.info("Visa fee: " + tempCount + " UAH added to bill");
    }

    public void countTransfer(boolean isTransfer, Bill bill){
        if(!isTransfer) {
            float tempCount = exchanger("USD", transfer);
            logger.info("Transfer: " + transfer + " USD");
            bill.setTransfer(tempCount);
            bill.setTotal(bill.getTotal() + tempCount);
            logger.info("Transfer: " + tempCount + " UAH added to bill");
        } else {
            bill.setTransfer(0f);
            logger.info("Transfer included to package price");
        }
    }

    public void countInsurance(boolean isInsurance, boolean isEu, int duration, Bill bill){
        if(!isInsurance){
            if(!isEu){
                if(duration>=12) {
                    float ins = insuranceTwelve*1.1F;
                    logger.info("Insurance not EU: " + insuranceTwelve + " UAH +10% more 12 days");
                    bill.setInsurance(ins);
                    bill.setTotal(bill.getTotal() + ins);
                    logger.info("Insurance not EU: " + ins + " UAH more 12 days added to bill");
                } else {
                    float ins = insurance*1.1F;
                    logger.info("Insurance not EU: " + insuranceTwelve + " UAH +10% less 12 days");
                    bill.setInsurance(ins);
                    bill.setTotal(bill.getTotal() + ins);
                    logger.info("Insurance not EU: " + ins + " UAH less 12 days to bill");
                }
            } else {
                if(duration>=12) {
                    bill.setInsurance(insuranceTwelve);
                    bill.setTotal(bill.getTotal() + insuranceTwelve);
                    logger.info("Insurance EU: " + insuranceTwelve + " UAH more 12 days added to bill");
                } else {
                    bill.setInsurance(insurance);
                    bill.setTotal(bill.getTotal() + insurance);
                    logger.info("Insurance EU: " + insurance + " UAH less 12 days to bill");
                }
            }
        } else {
            bill.setInsurance(0f);
            logger.info("Insurance included to package price");
        }
    }

    public void sumDiscount(Bill bill){
        float tempCount = exchanger("EUR", 2000);
        boolean flag = true;
        if(bill.getTotal()>=tempCount){
            tempCount = exchanger("EUR", 60);
            bill.setSumDiscount(tempCount);
            bill.setTotal(bill.getTotal()-tempCount);
            flag = false;
        } else {
            bill.setSumDiscount(0f);
        }
        tempCount = exchanger("EUR", 500);
        if(bill.getTotal()>= tempCount&&flag){
            tempCount = exchanger("EUR", 10);
            bill.setSumDiscount(tempCount);
            bill.setTotal(bill.getTotal()-tempCount);
        } else {
            bill.setSumDiscount(0f);
        }
    }

    public void dayDiscount(LocalDate dateDepart, Bill bill){
        if(dateDepart.getDayOfMonth()==independenceDay.getDayOfMonth()&&
                dateDepart.getMonthValue()==independenceDay.getMonthValue()){
            bill.setDayDiscount(bill.getTotal()*0.10f);
            bill.setTotal(bill.getTotal()*0.90F);
        }else if(dateDepart.getDayOfMonth()==tourismDay.getDayOfMonth()&&
                dateDepart.getMonthValue()==tourismDay.getMonthValue()){
            bill.setDayDiscount(bill.getTotal()*0.10f);
            bill.setTotal(bill.getTotal()*0.90F);
        } else bill.setDayDiscount(0f);
    }

    //This option doesn't work properly.. Need to add discount codes to DB...//
    public void certificateDiscount(String code, Bill bill){
        bill.setGiftCertificate(0f);
    }

    private float exchanger(String name, float value){
        float current;
        if(name.equals("USD")){
            current = value*usd;
        } else if(name.equals("EUR")){
            current = value*eur;
        } else return value;
        return current;
    }
}
