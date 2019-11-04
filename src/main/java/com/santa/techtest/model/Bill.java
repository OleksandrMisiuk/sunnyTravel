package com.santa.techtest.model;

public class Bill {
   private String transfer;
   private String insurance;
   private String visafee;
   private String packagePrice;
   private String mealPrice;
   private String roomPrice;
   private String giftCertificate;
   private String sumDiscount;
   private String dayDiscount;
   private String tourFee;
   private float total;

    public Bill(String transfer, String insurance, String visafee, String packagePrice,
                String mealPrice, String roomPrice, String giftCertificate, String sumDiscount, String dayDiscount,
                String tourFee, float total) {
        this.transfer = transfer;
        this.insurance = insurance;
        this.visafee = visafee;
        this.packagePrice = packagePrice;
        this.mealPrice = mealPrice;
        this.roomPrice = roomPrice;
        this.giftCertificate = giftCertificate;
        this.sumDiscount = sumDiscount;
        this.dayDiscount = dayDiscount;
        this.tourFee = tourFee;
        this.total = total;
    }

    public Bill() {
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getVisafee() {
        return visafee;
    }

    public void setVisafee(String visafee) {
        this.visafee = visafee;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(String mealPrice) {
        this.mealPrice = mealPrice;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(String giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public String getSumDiscount() {
        return sumDiscount;
    }

    public void setSumDiscount(String sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

    public String getDayDiscount() {
        return dayDiscount;
    }

    public void setDayDiscount(String dayDiscount) {
        this.dayDiscount = dayDiscount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getTourFee() {
        return tourFee;
    }

    public void setTourFee(String tourFee) {
        this.tourFee = tourFee;
    }

    @Override
    public String toString() {
        return "Bill{" +
                ", transfer='" + transfer + '\'' +
                ", insurance='" + insurance + '\'' +
                ", visafee='" + visafee + '\'' +
                ", packagePrice='" + packagePrice + '\'' +
                ", mealPrice='" + mealPrice + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", giftCertificate='" + giftCertificate + '\'' +
                ", sumDiscount='" + sumDiscount + '\'' +
                ", dayDiscount='" + dayDiscount + '\'' +
                ", tourFee='" + tourFee + '\'' +
                ", total=" + total +
                '}';
    }
}
