package com.github.godndas2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.godndas2.Diary;
import com.github.godndas2.repository.DiaryInterface;

@Controller
public class DiaryController {

	@Autowired
	DiaryInterface di;
	
	@RequestMapping("/")
	public String index(Model model) {
		//di.findAll()는 JpaRepository를 상속한 interface라고 부모가 물려준 method를 갖고 있다.
		model.addAttribute("diary", di.findAll());
		return "index";
	}
	
	/**
	 * Interface로 등록해놓은 DiaryInterface를 DI한다.
	 * (spring Controller와 같은 기능)
	 * "/" 경로로 오면 model에 di의 모든 정보를 담고 index.html로 보낸다
	 * "/diary" 경로로 오면 JSON형식으로 di의 모든 정보를 보낸다.
	 */
	
	@RequestMapping(value = "/diary", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public @ResponseBody List<Diary> getDiary() {
		return di.findAll();
	}
}
