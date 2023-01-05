package com.javatest.example.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javatest.example.dto.CurrencyVO;

import jakarta.transaction.Transactional;

public interface CurrencyVORepository extends CrudRepository<CurrencyVO, Long>{
	
	@Query("SELECT t FROM CurrencyVO t WHERE t.ename= :ename")
	CurrencyVO getCurrencyByEname(@Param("ename")String ename);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from CurrencyVO WHERE ename= :ename")
	void delCurrencyByEname(@Param("ename")String ename);	
}
