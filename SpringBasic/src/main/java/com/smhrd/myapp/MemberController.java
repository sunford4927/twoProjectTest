package com.smhrd.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.myapp.model.MavenMember;
import com.smhrd.myapp.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	// 회원가입 요청 처리 : localhost:8089/myapp/member/join
	
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String memberJoin(
			@RequestParam("id")String id,
			@RequestParam("pw")String pw,
			@RequestParam("nickname")String nickname
			) {
		System.out.println(id + ", "+ pw + " , " + nickname);
		
		// controller -> service -> mapper
		// controller : 요청 파라미터 받고 마지막에 뷰 리턴
		// service : controller 에 작성되는 코드 외에 로직들 작성
		// mapper : db 관련 작업
		
		MavenMember member = new MavenMember(id,pw,nickname);
		int res = service.memberJoin(member);
		System.out.println(res);
		
		// 포워딩 
		if(res>0)
		{
			// index.jsp
			// return 
			return "redirect:/index";
		}
		else
		{
			return "redirect:/join";
		}
		
	}
	
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String memberLogin(
				@RequestParam("id")String id,
				@RequestParam("pw")String pw
			)
	{
		return null;
	}
	
	
}
