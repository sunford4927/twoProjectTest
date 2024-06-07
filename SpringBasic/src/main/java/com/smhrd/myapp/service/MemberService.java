package com.smhrd.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.myapp.mapper.MemberMapper;
import com.smhrd.myapp.model.MavenMember;

@Service
public class MemberService {
	
	@Autowired //의존성 주입
	MemberMapper mapper;
	
	
	// 회원가입 처리
	public int memberJoin(MavenMember member)
	{
		return mapper.memberJoin(member);
	}
	
	// 로그인 처리
	public int memberLogin(MavenMember member)
	{
		return mapper.memberLogin(member);
	}
}
