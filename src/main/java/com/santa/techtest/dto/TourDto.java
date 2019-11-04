package com.santa.techtest.dto;

import java.time.LocalDate;

public class TourDto {
    private Long packageId;
    private Long roomId;
    private Long mealId;
    private String country;
    private String city;
    private String hotel;
    private LocalDate dateDepart;
    private int duration;
    private String description;
    private int numberOfPeople;
    private int seaDistance;
    private String roomType;
    private String meal;
    private int hotelRating;
    private boolean transfer;
    private boolean insurance;
    private boolean visa;

    public TourDto(Long packageId, Long roomId, Long mealId, String country, String city, String hotel, LocalDate dateDepart,
                      int duration, String description, int numberOfPeople, int seaDistance, String roomType, String meal, int hotelRating, boolean transfer, boolean insurance, boolean visa) {
        this.packageId = packageId;
        this.roomId = roomId;
        this.mealId = mealId;
        this.country = country;
        this.city = city;
        this.hotel = hotel;
        this.dateDepart = dateDepart;
        this.duration = duration;
        this.description = description;
        this.numberOfPeople = numberOfPeople;
        this.seaDistance = seaDistance;
        this.roomType = roomType;
        this.meal = meal;
        this.hotelRating = hotelRating;
        this.transfer = transfer;
        this.insurance = insurance;
        this.visa = visa;
    }

    public TourDto() {

    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getSeaDistance() {
        return seaDistance;
    }

    public void setSeaDistance(int seaDistance) {
        this.seaDistance = seaDistance;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
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

    public boolean isVisa() {
        return visa;
    }

    public void setVisa(boolean visa) {
        this.visa = visa;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "packageId=" + packageId +
                ", roomId=" + roomId +
                ", mealId=" + mealId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hotel='" + hotel + '\'' +
                ", dateDepart=" + dateDepart +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", seaDistance=" + seaDistance +
                ", roomType='" + roomType + '\'' +
                ", meal='" + meal + '\'' +
                ", hotelRating=" + hotelRating +
                ", transfer=" + transfer +
                ", insurance=" + insurance +
                ", visa=" + visa +
                '}';
    }
}