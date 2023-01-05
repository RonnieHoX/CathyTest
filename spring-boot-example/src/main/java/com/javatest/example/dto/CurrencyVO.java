package com.javatest.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency") // 引入@Table註解，name賦值為表名
public class CurrencyVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	private String cname;
	private String ename;
	private String rate;
	private String symbol;
	private String memo;
	private double rate_float;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public double getRate_float() {
		return rate_float;
	}

	public void setRate_float(double rate_float) {
		this.rate_float = rate_float;
	}

	@Override
	public String toString() {
		return "currency{" + "cname='" + cname 
				+ '\'' + ", ename='" + ename 
				+ '\'' + ", rate='" + rate
				+ '\'' + ", symbol='" + symbol
				+ '\'' + ", memo='" + memo
				+ '\'' + ", rate_float='" + rate_float
				+ '\'' + '}';
	}

}
