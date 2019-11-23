package com.santa.techtest.model;

public class Bill {
   private float transfer;
   private float insurance;
   private float visafee;
   private float packagePrice;
   private float mealPrice;
   private float roomPrice;
   private float giftCertificate;
   private float sumDiscount;
   private float dayDiscount;
   private float tourFee;
   private float total;

    public Bill(float transfer, float insurance, float visafee, float packagePrice, float mealPrice, float roomPrice,
                float giftCertificate, float sumDiscount, float dayDiscount, float tourFee, float total) {
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

    public float getTransfer() {
        return transfer;
    }

    public void setTransfer(float transfer) {
        this.transfer = transfer;
    }

    public float getInsurance() {
        return insurance;
    }

    public void setInsurance(float insurance) {
        this.insurance = insurance;
    }

    public float getVisafee() {
        return visafee;
    }

    public void setVisafee(float visafee) {
        this.visafee = visafee;
    }

    public float getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(float packagePrice) {
        this.packagePrice = packagePrice;
    }

    public float getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(float mealPrice) {
        this.mealPrice = mealPrice;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public float getGiftCertificate() {
        return giftCertificate;
    }

    public void setGiftCertificate(float giftCertificate) {
        this.giftCertificate = giftCertificate;
    }

    public float getSumDiscount() {
        return sumDiscount;
    }

    public void setSumDiscount(float sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

    public float getDayDiscount() {
        return dayDiscount;
    }

    public void setDayDiscount(float dayDiscount) {
        this.dayDiscount = dayDiscount;
    }

    public float getTourFee() {
        return tourFee;
    }

    public void setTourFee(float tourFee) {
        this.tourFee = tourFee;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "transfer=" + transfer +
                ", insurance=" + insurance +
                ", visafee=" + visafee +
                ", packagePrice=" + packagePrice +
                ", mealPrice=" + mealPrice +
                ", roomPrice=" + roomPrice +
                ", giftCertificate=" + giftCertificate +
                ", sumDiscount=" + sumDiscount +
                ", dayDiscount=" + dayDiscount +
                ", tourFee=" + tourFee +
                ", total=" + total +
                '}';
    }

    public String toEmail(){
        return  "Transfer=" + transfer + ",\n" +
                "Insurance=" + insurance + ",\n" +
                "Visa fee=" + visafee + ",\n" +
                "Package price=" + packagePrice + ",\n" +
                "Meal price=" + mealPrice + ",\n" +
                "Room price=" + roomPrice + ",\n" +
                "Gift certificate discount=" + giftCertificate + ",\n" +
                "Sum discount=" + sumDiscount + ",\n" +
                "Day discount=" + dayDiscount + ",\n" +
                "Tour fee=" + tourFee + ",\n" +
                "Total=" + total;
    }
}
