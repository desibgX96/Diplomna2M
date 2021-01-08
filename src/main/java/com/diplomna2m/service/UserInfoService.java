package com.diplomna2m.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.diplomna2m.exeptions.ExistingUserEmailExeption;
import com.diplomna2m.exeptions.UserPasswordRequiredExeption;
import com.diplomna2m.model.PotentialUser;
import com.diplomna2m.model.UserInfo;
import com.diplomna2m.repository.UserInfoRepository;

@Service
public class UserInfoService implements UserInfoServiseInterface {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public void save(UserInfo object) {
		userInfoRepository.save(object);
	}
	
	@Transactional
	public void safeUser(UserInfo userInfo) {
		Optional<UserInfo> existingUser = userInfoRepository.findByEmail(userInfo.getEmail());
		if (existingUser.isPresent()) {
			throw new ExistingUserEmailExeption("Електронната поща вече е регистрирана от друг потребител");
		}
		
		if (userInfo.isNewUser() && StringUtils.isEmpty(userInfo.getPassword())) {
			throw new UserPasswordRequiredExeption("Паролата е задължителна при нов потребител!!!");
		}
		
		userInfoRepository.save(userInfo);
	}
	
	@Override
	public List<UserInfo> findUserProfile(PotentialUser userInfo) {
		return userInfoRepository.findUserProfile(userInfo.getUserName(),userInfo.getPassword());
	}

}
