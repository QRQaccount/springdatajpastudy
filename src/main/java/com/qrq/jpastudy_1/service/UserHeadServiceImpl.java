package com.qrq.jpastudy_1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrq.jpastudy_1.pojo.UserHead;
import com.qrq.jpastudy_1.repositories.UserHeadRepository;

@Service
public class UserHeadServiceImpl implements UserHeadService {
	@Autowired
	private UserHeadRepository userHeadRepository;

	@Override
	public void save(UserHead userHead) {
		userHeadRepository.save(userHead);
	}

	@Override
	public UserHead findUserHeadById(Long id) {
		Optional<UserHead> userOptional = userHeadRepository.findById(id);
		return userOptional.get();
	}

}
