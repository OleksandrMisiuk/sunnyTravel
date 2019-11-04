package com.santa.techtest.dao;

public interface CurrencyDao {
    float getValue(String name);
    boolean setValue(float value, String name);
}
