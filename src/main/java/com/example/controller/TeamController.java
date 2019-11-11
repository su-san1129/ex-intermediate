package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * チーム情報を操作するコントローラー.
 * 
 * @author takahiro.suzuki
 *
 */
@Controller
@RequestMapping("/")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * 球団一覧を表示します.
	 * 
	 * @param model リクエストスコープ
	 * @return 球団一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "showList";
	}
	
	/**
	 * 球団の詳細情報を表示します.
	 * 
	 * @param id リクエストパラメーターで送られてくる球団の主キー
	 * @param model リクエストスコープ
	 * @return 球団の詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showTeamDetail(Integer id, Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "showDetail";
	}

}
