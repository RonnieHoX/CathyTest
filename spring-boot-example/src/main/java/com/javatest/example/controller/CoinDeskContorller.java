package com.javatest.example.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.javatest.example.dto.CoinDeskVO;
import com.javatest.example.dto.CurrencyVO;
import com.javatest.example.dto.PersonCurrencyVO;
import com.javatest.example.model.Coindesk;
import com.javatest.example.model.NewCoindesk;
import com.javatest.example.repository.CoinDeskVORepository;
import com.javatest.example.repository.CurrencyVORepository;
import com.javatest.example.repository.PersonCurrencyVORepository;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("/coinDesk")
public class CoinDeskContorller {
	
	DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
    @Autowired
    CoinDeskVORepository coinRepo;
	
    @Autowired
    CurrencyVORepository currRepo;
    
    @Autowired
    PersonCurrencyVORepository perCurrRepo;
    
    @GetMapping("/insertMessage")
    public String insertMessage(String message) {
    	Coindesk data = new Gson().fromJson(message, Coindesk.class);
    	LocalDateTime now = LocalDateTime.now();    
    	CoinDeskVO coin = new CoinDeskVO();
    	coin.setUpdateTime(df.format(now));
    	coin.setChartname(data.getChartName());
    	coin.setDisclaimer(data.getDisclaimer());
    	coin.setUpdated(data.getTime().getUpdated());
    	coin.setUpdatediso(data.getTime().getUpdatedISO());
    	coin.setUpdateduk(data.getTime().getUpdateduk());
    	
    	coinRepo.save(coin);
    	System.out.println("id:"+coin.getId());
    	
    	PersonCurrencyVO perCurr = new PersonCurrencyVO();
    	CurrencyVO currency = currRepo.getCurrencyByEname(data.getBpi().getEur().getCode());
    	perCurr.setCoindesk_id(coin.getId());
    	perCurr.setCode(data.getBpi().getEur().getCode());
    	perCurr.setCname(currency.getCname());
    	perCurr.setSymbol(data.getBpi().getEur().getSymbol());
    	perCurr.setDescription(data.getBpi().getEur().getDescription());
    	perCurr.setRate(data.getBpi().getEur().getRate().replace(",", ""));
    	perCurr.setRate_float(data.getBpi().getEur().getRate_float());
    	perCurrRepo.save(perCurr);
    	
    	perCurr = new PersonCurrencyVO();
    	currency = currRepo.getCurrencyByEname(data.getBpi().getGbp().getCode());
    	perCurr.setCoindesk_id(coin.getId());
    	perCurr.setCode(data.getBpi().getGbp().getCode());
    	perCurr.setCname(currency.getCname());
    	perCurr.setSymbol(data.getBpi().getGbp().getSymbol());
    	perCurr.setDescription(data.getBpi().getGbp().getDescription());
    	perCurr.setRate(data.getBpi().getGbp().getRate().replace(",", ""));
    	perCurr.setRate_float(data.getBpi().getGbp().getRate_float());
    	perCurrRepo.save(perCurr);
    	
    	perCurr = new PersonCurrencyVO();
    	currency = currRepo.getCurrencyByEname(data.getBpi().getUsd().getCode());
    	perCurr.setCoindesk_id(coin.getId());
    	perCurr.setCode(data.getBpi().getUsd().getCode());
    	perCurr.setCname(currency.getCname());
    	perCurr.setSymbol(data.getBpi().getUsd().getSymbol());
    	perCurr.setDescription(data.getBpi().getUsd().getDescription());
    	perCurr.setRate(data.getBpi().getUsd().getRate().replace(",", ""));
    	perCurr.setRate_float(data.getBpi().getUsd().getRate_float());
    	perCurrRepo.save(perCurr);
    	
    	try {
			return this.getMessage(coin.getId());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "insert fail";
		}
	}
    
    @GetMapping("/updateMessage")
    public String updateMessage(String message) throws JsonProcessingException {
    	Coindesk data = new Gson().fromJson(message, Coindesk.class);
    	LocalDateTime now = LocalDateTime.now();    
    	
    	if (StringUtils.isNotBlank(String.valueOf(data.getId()))) 
    	{ 
    		CoinDeskVO coin = new CoinDeskVO();
	    	coin.setUpdateTime(df.format(now));
	    	coin.setId(data.getId());
	    	coin.setChartname(data.getChartName());
	    	coin.setDisclaimer(data.getDisclaimer());
	    	coin.setUpdated(data.getTime().getUpdated());
	    	coin.setUpdatediso(data.getTime().getUpdatedISO());
	    	coin.setUpdateduk(data.getTime().getUpdateduk());
	    	
	    	coinRepo.save(coin);
	    	System.out.println("id:"+coin.getId());
	    	
	    	perCurrRepo.updPersonCurrency(data.getId(), data.getBpi().getEur().getCode(), 
	    			data.getBpi().getEur().getSymbol(), data.getBpi().getEur().getRate().replace(",", ""),
	    			data.getBpi().getEur().getDescription(), data.getBpi().getEur().getRate_float());
	    	
	    	perCurrRepo.updPersonCurrency(data.getId(), data.getBpi().getGbp().getCode(), 
	    			data.getBpi().getGbp().getSymbol(), data.getBpi().getGbp().getRate().replace(",", ""),
	    			data.getBpi().getGbp().getDescription(), data.getBpi().getGbp().getRate_float());
	    	
	    	perCurrRepo.updPersonCurrency(data.getId(), data.getBpi().getUsd().getCode(), 
	    			data.getBpi().getUsd().getSymbol(), data.getBpi().getUsd().getRate().replace(",", ""),
	    			data.getBpi().getUsd().getDescription(), data.getBpi().getUsd().getRate_float());
	    	return this.getMessage(coin.getId());
    	}
    	return "update fail";
    }
    
	@GetMapping("/getMessage")
    public String getMessage(Long id) throws JsonProcessingException {
    	Optional<CoinDeskVO> coin = coinRepo.findById(id);
    	if (coin.isPresent()) {
    		 NewCoindesk newCoin = new NewCoindesk();

    		 List<NewCoindesk.bpi> listBpi = new ArrayList<NewCoindesk.bpi>();
    		 newCoin.setId(id);
    		 newCoin.setChartName(coin.get().getChartname());
    		 newCoin.setDisclaimer(coin.get().getDisclaimer());
    		 newCoin.setUpdate_time(coin.get().getUpdateTime());
    		 newCoin.setUpdated(coin.get().getUpdated());
    		 newCoin.setUpdatedISO(coin.get().getUpdatediso());
    		 newCoin.setUpdateduk(coin.get().getUpdateduk());
    		
    		 List<PersonCurrencyVO> listPerCurr = perCurrRepo.findAllByCoindeskId(id);
    		 
    		 listPerCurr.forEach(perCurr -> {
        		 NewCoindesk.bpi bpi = new NewCoindesk.bpi();
    			 bpi.setCode(perCurr.getCode());
    			 bpi.setCname(perCurr.getCname());
    			 bpi.setDescription(perCurr.getDescription());
    			 bpi.setRate(perCurr.getRate());
    			 bpi.setRate_float(perCurr.getRate_float());
    			 bpi.setSymbol(perCurr.getSymbol());
    			 listBpi.add(bpi);
    		 });
    		 newCoin.setBpi(listBpi);
    		 
    		 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    		 String json = ow.writeValueAsString(newCoin);
    		 
    		 return json;
    	}
    	return "fail";
    }
}
