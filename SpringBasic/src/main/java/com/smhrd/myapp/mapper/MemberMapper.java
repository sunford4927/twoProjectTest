package com.smhrd.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.myapp.model.MavenMember;

@Mapper
public interface MemberMapper {
	// 회원가입 처리
	public int memberJoin(MavenMember member);
	
	public int memberLogin(MavenMember member);
	
}
