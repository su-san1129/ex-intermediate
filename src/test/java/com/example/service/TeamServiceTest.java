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

import com.example.domain.Team;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceTest {
	
	@Autowired
	private TeamService teamService;

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
	public void testShowList() {
		System.out.println("全件検索するテスト開始");
		
		List<Team> teamList = teamService.showList();
		
		assertThat("件数が一致しません", teamList.size(), is(6));
		assertThat("発足順に並んでいません", teamList.get(0).getTeamName(), is("読売ジャイアンツ"));
		assertThat("発足順に並んでいません", teamList.get(4).getTeamName(), is("広島東洋カープ"));
		
		System.out.println("全件検索するテスト終了");
	}
	
	@Test
	public void testShowDetail() {
		System.out.println("詳細情報を検索するテスト開始");
		
		Team team = teamService.showDetail(1);
		
		assertThat("名前が一致しません", team.getTeamName(), is("読売ジャイアンツ"));
		assertThat("本拠地が一致しません", team.getHeadquarters(), is("東京ドーム（東京都・文京区）"));
		
		System.out.println("詳細情報を検索するテスト終了");
	}

}
