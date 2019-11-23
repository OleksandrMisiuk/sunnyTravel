package com.santa.techtest;

import com.santa.techtest.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechtestApplicationTests {

	@Autowired
	EmailService emailService;
	@Test
	public void contextLoads() {
	}

//	@Test
//	public void emailSenderTest()
//	{
//		emailService.sendSimpleMessage("Subject",
//				"Hello Dear, How are you ?",
//				"test.sunnytravel@gmail.com");
//
//	}
}
