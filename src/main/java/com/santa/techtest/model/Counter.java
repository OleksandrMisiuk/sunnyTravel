package com.santa.techtest.model;

import java.time.LocalDate;

public class Counter {
    private boolean transfer;
    private boolean insurance;
    private Long packagePrice;
    private Long visaFee;
    private String packagePriceType;
    private Long mealPrice;
    private String hotelPriceType;
    private Long roomPrice;
    private int numberOfPeople;
    private int duration;
    private LocalDate dateDepart;
    private String visaFeeTypePrice;
    private boolean eu;

    public Counter(boolean transfer, boolean insurance, Long packagePrice, Long visaFee, String packagePriceType,
                   Long mealPrice, String hotelPriceType, Long roomPrice, int numberOfPeople, int duration,
                   LocalDate dateDepart, String visaFeeTypePrice, boolean eu) {
        this.transfer = transfer;
        this.insurance = insurance;
        this.packagePrice = packagePrice;
        this.visaFee = visaFee;
        this.packagePriceType = packagePriceType;
        this.mealPrice = mealPrice;
        this.hotelPriceType = hotelPriceType;
        this.roomPrice = roomPrice;
        this.numberOfPeople = numberOfPeople;
        this.duration = duration;
        this.dateDepart = dateDepart;
        this.visaFeeTypePrice = visaFeeTypePrice;
        this.eu = eu;
    }

    public Counter() {

    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public Long getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(Long packagePrice) {
        this.packagePrice = packagePrice;
    }

    public Long getVisaFee() {
        return visaFee;
    }

    public void setVisaFee(Long visaFee) {
        this.visaFee = visaFee;
    }

    public String getPackagePriceType() {
        return packagePriceType;
    }

    public void setPackagePriceType(String packagePriceType) {
        this.packagePriceType = packagePriceType;
    }

    public Long getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(Long mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getHotelPriceType() {
        return hotelPriceType;
    }

    public void setHotelPriceType(String hotelPriceType) {
        this.hotelPriceType = hotelPriceType;
    }

    public Long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getVisaFeeTypePrice() {
        return visaFeeTypePrice;
    }

    public void setVisaFeeTypePrice(String visaFeeTypePrice) {
        this.visaFeeTypePrice = visaFeeTypePrice;
    }

    public boolean isEu() {
        return eu;
    }

    public void setEu(boolean eu) {
        this.eu = eu;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "transfer=" + transfer +
                ", insurance=" + insurance +
                ", packagePrice=" + packagePrice +
                ", visaFee=" + visaFee +
                ", packagePriceType='" + packagePriceType + '\'' +
                ", mealPrice=" + mealPrice +
                ", hotelPriceType='" + hotelPriceType + '\'' +
                ", roomPrice=" + roomPrice +
                ", numberOfPeople=" + numberOfPeople +
                ", duration=" + duration +
                ", dateDepart=" + dateDepart +
                ", visaFeeTypePrice='" + visaFeeTypePrice + '\'' +
                ", eu=" + eu +
                '}';
    }
}
