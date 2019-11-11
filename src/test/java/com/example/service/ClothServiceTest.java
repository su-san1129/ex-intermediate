package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Cloth;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClothServiceTest {
	
	@Autowired
	private ClothService clothService;

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
	public void serchByColorAndGenderTest() {
		
		System.out.println("テストを開始");

		Cloth cloth = clothService.searchByColorAndGender(0, "赤");
		assertThat("genreが一致しません", cloth.getGenre(), is("ジャケット"));
		assertThat("categoryが一致しません", cloth.getCategory(), is("洋服"));
		
		System.out.println("テストを終了");
	}
	@Test
	public void serchByColorAndGenderTest2() {
		
		System.out.println("テストを開始");
		try {
			Cloth cloth = clothService.searchByColorAndGender(1, "赤");
			fail("TC２:例外が発生しなければなりません");
		} catch (Exception e) {
		}
		
		System.out.println("テストを終了");
	}

}
