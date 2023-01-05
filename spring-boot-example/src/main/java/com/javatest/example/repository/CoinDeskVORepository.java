package com.javatest.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatest.example.dto.CoinDeskVO;

public interface CoinDeskVORepository extends CrudRepository<CoinDeskVO, Long>{
	
	
}
