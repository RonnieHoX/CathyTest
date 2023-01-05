package com.javatest.example.model;

public class Coindesk {

	private Long id;
	private time time;
	private String disclaimer;
	private String chartName;
	private bpi bpi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public time getTime() {
		return time;
	}

	public void setTime(time time) {
		this.time = time;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public bpi getBpi() {
		return bpi;
	}

	public void setBpi(bpi bpi) {
		this.bpi = bpi;
	}

	public class bpi {

		private USD USD;
		private GBP GBP;
		private EUR EUR;

		public USD getUsd() {
			return USD;
		}

		public void setUsd(USD usd) {
			this.USD = usd;
		}

		public GBP getGbp() {
			return GBP;
		}

		public void setGbp(GBP gbp) {
			this.GBP = gbp;
		}

		public EUR getEur() {
			return EUR;
		}

		public void setEur(EUR eur) {
			this.EUR = eur;
		}

		public class USD {
			private String code;
			private String symbol;
			private String rate;
			private String description;
			private double rate_float;

			public String getCode() {
				return code;
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

		}

		public class GBP {
			private String code;
			private String symbol;
			private String rate;
			private String description;
			private double rate_float;

			public String getCode() {
				return code;
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

		}

		public class EUR {
			private String code;
			private String symbol;
			private String rate;
			private String description;
			private double rate_float;

			public String getCode() {
				return code;
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

		}

	}

	public class time {

		private String updated;
		private String updatedISO;
		private String updateduk;

		public String getUpdated() {
			return updated;
		}

		public void setUpdated(String updated) {
			this.updated = updated;
		}

		public String getUpdatedISO() {
			return updatedISO;
		}

		public void setUpdatedISO(String updatedISO) {
			this.updatedISO = updatedISO;
		}

		public String getUpdateduk() {
			return updateduk;
		}

		public void setUpdateduk(String updateduk) {
			this.updateduk = updateduk;
		}

		@Override
		public String toString() {
			return getUpdated() + ", " + getUpdatedISO() + ", " + getUpdateduk();
		}
	}

}
