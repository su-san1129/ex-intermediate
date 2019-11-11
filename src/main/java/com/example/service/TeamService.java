package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Team;
import com.example.repository.TeamRepository;

/**
 * チームの情報を操作するサービスクラス.
 * 
 * @author takahiro.suzuki
 *
 */
@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 球団情報を全件取得します.
	 * 
	 * @return 球団の全件検索
	 */
	public List<Team> showList(){
		return teamRepository.findAll();
	}
	
	/**
	 * 
	 * 球団情報を取得します.
	 * 
	 * @param id ID
	 * @return IDで取得した球団情報
	 */
	public Team showDetail(Integer id) {
		return teamRepository.load(id);
	}

}
