package com.javatest.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javatest.example.dto.PersonCurrencyVO;

import jakarta.transaction.Transactional;

public interface PersonCurrencyVORepository extends CrudRepository<PersonCurrencyVO, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update PersonCurrencyVO a \r\n"
			+ "set description = :description ,rate = :rate ,rate_float = :rate_float, symbol = :symbol\r\n"
			+ "where code = :code and coindesk_id = :coindesk_id")
	void updPersonCurrency(@Param("coindesk_id") Long coindesk_id,@Param("code") String code,@Param("symbol") String symbol,
			@Param("rate") String rate,@Param("description") String description,@Param("rate_float") double rate_float);
	
	
	@Query("SELECT t FROM PersonCurrencyVO t WHERE t.coindesk_id= :coindesk_id")
	List<PersonCurrencyVO> findAllByCoindeskId(@Param("coindesk_id") Long coindesk_id);
	

}
