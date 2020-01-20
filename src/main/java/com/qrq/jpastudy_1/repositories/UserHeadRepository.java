package com.qrq.jpastudy_1.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qrq.jpastudy_1.pojo.UserHead;

public interface UserHeadRepository extends JpaRepository<UserHead, Long> {
	
}
