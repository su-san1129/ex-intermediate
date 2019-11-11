package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Hotel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
	
	@Autowired
	private HotelService hotelService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void serchTest() {
		List<Hotel> hotelList = hotelService.serchByLessThanPrice(10000);
		
		assertThat("TC1:ホテル名が一致しません", hotelList.get(0).getHotelName(), is("ホテルローズガーデン新宿"));
		assertThat("TC2:最寄り駅が一致しません", hotelList.get(0).getNearestStation(), is("西新宿駅"));
		
	}
	@Test
	public void serchTest2() {
		List<Hotel> hotelList = hotelService.showHotelList();
		
		assertThat("TC3:ホテル名が一致しません", hotelList.get(0).getHotelName(), is("ホテルローズガーデン新宿"));
		assertThat("TC4:最寄り駅が一致しません", hotelList.get(0).getNearestStation(), is("西新宿駅"));
		assertThat("TC5:ホテル名が一致しません", hotelList.get(2).getHotelName(), is("渋谷エクセルホテル東急"));
		assertThat("TC6:最寄り駅が一致しません", hotelList.get(2).getNearestStation(), is("渋谷駅"));
		
	}

}
