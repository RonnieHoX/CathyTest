package com.javatest.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.javatest.example.dto.CurrencyVO;
import com.javatest.example.repository.CurrencyVORepository;


@RestController
@RequestMapping("/currency")
public class CurrencyController {

	Logger logger = Logger.getLogger(CurrencyController.class);
	
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	
    @Autowired
    CurrencyVORepository currRepo;
    
    /**
     * <p>Get all person data in the system.For production system you many want to use
     * pagination.</p>
     * @return List<personsCustomerData>
     */
	@GetMapping
    public List<CurrencyVO> getAllCurrency(){
    	Iterable<CurrencyVO> it = currRepo.findAll();
    	List<CurrencyVO> listPerson = new ArrayList<CurrencyVO>();
    	it.forEach(listPerson::add);
    	
    	return listPerson;
    }
    
    /**
     * Method to get the currency data based on the ID.
     * @param id
     * @return CurrencyVO
     */
    @GetMapping("/getCurrency/{id}")
    public CurrencyVO getCurrency(@PathVariable Long id){
        Optional<CurrencyVO> currency = Optional.ofNullable(currRepo.findById(id).get());
        if (currency.isPresent()) {
            System.out.println(currency.get());
            return currency.get();
        } else {
            System.out.println("currency is null.");
        }
    	return null;
    }
    
    @GetMapping("/delete")
    public String delCurrency(Long id){
    	try {
    		currRepo.deleteById(id);
    		return "delete the currency is success";
    	}catch(EmptyResultDataAccessException e) {
    		System.out.println(e.getMessage());
    		return "data is not exist!!";
    	}
    }
    
    @GetMapping("/delete/ename")
    public String delCurrencyByEname(String ename){
    	try {
    		currRepo.delCurrencyByEname(ename);
    		return "delete the currency is success";
    	}catch(EmptyResultDataAccessException e) {
    		System.out.println(e.getMessage());
    		return "data is not exist!!";
    	}
    }
    
    
    @GetMapping("/insert")
    public String insertCurrency(String cname,String ename,String rate,String symbol,
    		String memo,double rate_float) throws JsonProcessingException{
    	try {
    		CurrencyVO curr = currRepo.getCurrencyByEname(ename);
    		if (curr == null) {
    			curr = new CurrencyVO();
    		}
    		curr.setCname(cname);
    		curr.setEname(ename);
    		curr.setRate(rate);
    		curr.setSymbol(symbol);
    		curr.setMemo(memo);
    		curr.setRate_float(rate_float);
    		currRepo.save(curr);
    		String json = ow.writeValueAsString(curr);
    		return json;
    	}catch(EmptyResultDataAccessException e) {
    		System.out.println(e.getMessage());
    		return "data is not exist!!";
    	}
    }
    
    @GetMapping("/update")
    public String updateCurrency(Long id,String cname,String ename,String rate,String symbol,
    		String memo,double rate_float) throws JsonProcessingException{
    	try {
    		CurrencyVO curr = new CurrencyVO();
    		logger.info(id);
    		curr.setId(id);
    		curr.setCname(cname);
    		curr.setEname(ename);
    		curr.setRate(rate);
    		curr.setSymbol(symbol);
    		curr.setMemo(memo);
    		curr.setRate_float(rate_float);
    		currRepo.save(curr);
    		String json = ow.writeValueAsString(curr);
    		return json;
    	}catch(EmptyResultDataAccessException e) {
    		System.out.println(e.getMessage());
    		return "data is not exist!!";
    	}
    }
    
}
