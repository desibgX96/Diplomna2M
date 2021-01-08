package com.diplomna2m.service;

import java.util.List;

import javax.validation.Valid;

import com.diplomna2m.model.PotentialUser;
import com.diplomna2m.model.UserInfo;

public interface UserInfoServiseInterface {

	void save(UserInfo object);

	List<UserInfo> findUserProfile(PotentialUser userInfo);

	void safeUser(@Valid UserInfo userInfo);
	
}
