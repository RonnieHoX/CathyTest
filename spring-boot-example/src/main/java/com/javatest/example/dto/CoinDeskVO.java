package com.javatest.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coindesk") // 引入@Table註解，name賦值為表名
public class CoinDeskVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	private String updated;
	private String updatediso;
	private String updateduk;
	private String disclaimer;
	private String chartname;
	private String updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatediso() {
		return updatediso;
	}

	public void setUpdatediso(String updatediso) {
		this.updatediso = updatediso;
	}

	public String getUpdateduk() {
		return updateduk;
	}

	public void setUpdateduk(String updateduk) {
		this.updateduk = updateduk;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartname() {
		return chartname;
	}

	public void setChartname(String chartname) {
		this.chartname = chartname;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "currency{" + "id='" + id + '\'' 
				+ ", updated='" + updated + '\'' 
				+ ", updatediso='" + updatediso + '\''
				+ ", updateduk='" + updateduk + '\'' 
				+ ", disclaimer='" + disclaimer + '\'' 
				+ ", chartname='" + chartname + '\''
				+ ", updateTime='" + updateTime + '\''
				+ '}';
	}

}
