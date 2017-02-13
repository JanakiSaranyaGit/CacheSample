package cache.staticData;

import java.sql.Date;

public class Country implements java.io.Serializable {

	/* REF_COUNTRY 
	 Column Name 	Pk 	Data Type 
	 COUNTRY_ID 	1 	NUMBER (9) 
	 COUNTRY_CD 	VARCHAR2 (20 Byte) 
	 COUNTRY_NAME 	VARCHAR2 (50 Byte) 
	 STATUS_IND 	NUMBER (3) 
	 LAST_MODIFY_DT 	DATE 
	 MODIFY_PERSON_NUM 	NUMBER (9) */

	Integer countryId;
	String countryCd;
	String countryName;
	Integer StatusInd;
	Date lastModifiedDt;
	Integer modifyPersonNum;
	
	

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(Integer countryId, String countryCd, String countryName, Integer statusInd, Date lastModifiedDt,
			Integer modifyPersonNum) {
		super();
		this.countryId = countryId;
		this.countryCd = countryCd;
		this.countryName = countryName;
		StatusInd = statusInd;
		this.lastModifiedDt = lastModifiedDt;
		this.modifyPersonNum = modifyPersonNum;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryCd() {
		return countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
	public String toString() {
		return "Country [countryId=" + countryId + ", countryCd=" + countryCd + ", countryName=" + countryName
				+ ", StatusInd=" + StatusInd + ", lastModifiedDt=" + lastModifiedDt + ", modifyPersonNum="
				+ modifyPersonNum + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
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
		Country other = (Country) obj;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		return true;
	}

	
	
	
}
