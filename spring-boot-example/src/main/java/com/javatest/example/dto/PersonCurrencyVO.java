package com.javatest.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_currency") // 引入@Table註解，name賦值為表名
public class PersonCurrencyVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	private Long coindesk_id;
	private String code;
	private String cname;
	private String symbol;
	private String rate;
	private String description;
	private double rate_float;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCoindesk_id() {
		return coindesk_id;
	}

	public void setCoindesk_id(Long coindesk_id) {
		this.coindesk_id = coindesk_id;
	}

	public String getCode() {
		return code;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRate_float() {
		return rate_float;
	}

	public void setRate_float(double rate_float) {
		this.rate_float = rate_float;
	}

	@Override
	public String toString() {
		return "currency{" + "id='" + id + '\'' + ", code='" + code + '\'' + ", symbol='" + symbol + '\'' + ", rate='"
				+ rate + '\'' + ", description='" + description + '\'' + ", rate_float='" + rate_float + '\'' + '}';
	}

}
