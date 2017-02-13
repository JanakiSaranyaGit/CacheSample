package cache.staticData;

import java.sql.Date;

public class Currency implements java.io.Serializable{

	/*CURR_ID 	1 	NUMBER (9) 
	CURR_CD 	VARCHAR2 (3 Byte) 
	CURR_NAME 	VARCHAR2 (50 Byte) 
	CURRENCY_SYMBOL 	VARCHAR2 (5 Byte) 
	STATUS_IND 	NUMBER (3) 
	LAST_MODIFY_DT 	DATE 
	MODIFY_PERSON_NUM 	NUMBER (9) */
	

	Integer currencyId;
	String currencyCd;
	String currencyName;
	String currencySymbol;
	Integer StatusInd;
	Date lastModifiedDt;
	Integer modifyPersonNum;
	
	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Currency(Integer currencyId, String currencyCd, String currencyName, String currencySymbol,
			Integer statusInd, Date lastModifiedDt, Integer modifyPersonNum) {
		super();
		this.currencyId = currencyId;
		this.currencyCd = currencyCd;
		this.currencyName = currencyName;
		this.currencySymbol = currencySymbol;
		StatusInd = statusInd;
		this.lastModifiedDt = lastModifiedDt;
		this.modifyPersonNum = modifyPersonNum;
	}
	
	public Integer getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	public Integer getStatusInd() {
		return StatusInd;
	}
	public void setStatusInd(Integer statusInd) {
		StatusInd = statusInd;
	}
	public Date getLastModifiedDt() {
		return lastModifiedDt;
	}
	public void setLastModifiedDt(Date lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}
	public Integer getModifyPersonNum() {
		return modifyPersonNum;
	}
	public void setModifyPersonNum(Integer modifyPersonNum) {
		this.modifyPersonNum = modifyPersonNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyId == null) ? 0 : currencyId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (currencyId == null) {
			if (other.currencyId != null)
				return false;
		} else if (!currencyId.equals(other.currencyId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", currencyCd=" + currencyCd + ", currencyName=" + currencyName
				+ ", currencySymbol=" + currencySymbol + ", StatusInd=" + StatusInd + ", lastModifiedDt="
				+ lastModifiedDt + ", modifyPersonNum=" + modifyPersonNum + "]";
	}

}
