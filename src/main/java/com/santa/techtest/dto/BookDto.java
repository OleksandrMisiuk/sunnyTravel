package com.santa.techtest.dto;

public class BookDto {
    private Long packageId;
    private Long mealId;
    private Long roomId;
    private String discountCode;

    public BookDto(Long packageId, Long mealId, Long roomId, String discountCode) {
        this.packageId = packageId;
        this.mealId = mealId;
        this.roomId = roomId;
        this.discountCode = discountCode;
    }

    public BookDto() {
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Override
    public String toString() {
        return "Book{" +
                "packageId=" + packageId +
                ", mealId=" + mealId +
                ", roomId=" + roomId +
                ", discountCode='" + discountCode + '\'' +
                '}';
    }
}
