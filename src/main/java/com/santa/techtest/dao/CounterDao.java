package com.santa.techtest.dao;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.model.Counter;

public interface CounterDao {
    Counter getBill(BookDto bookDto);
}
