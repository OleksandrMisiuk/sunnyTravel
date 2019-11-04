package com.santa.techtest.service;

import com.santa.techtest.dto.BookDto;
import com.santa.techtest.model.Bill;

public interface CounterService {
    Bill getBill(BookDto bookDto);
}
