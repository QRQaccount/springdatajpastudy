package com.qrq.jpastudy_1.service;

import com.qrq.jpastudy_1.pojo.UserHead;

public interface UserHeadService {
	void save(UserHead userHead);

	UserHead findUserHeadById(Long id);
}
