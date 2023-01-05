package com.javatest.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatest.example.dto.PersonVO;

public interface PersonVORepository extends CrudRepository<PersonVO, Long>{
	

}
