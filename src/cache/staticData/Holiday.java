package cache.staticData;

import java.sql.Date;

public class Holiday {

	

	/* HOLIDAY_ID 	1 	NUMBER (9) 
	HOLIDAY_CD 	VARCHAR2 (30 Byte) 
	HOLIDAY_NAME 	VARCHAR2 (50 Byte) 
	HOLIDAY_DT 	DATE 
	STATUS_IND 	NUMBER (3) 
	LAST_MODIFY_DT 	DATE 
	MODIFY_PERSON_NUM 	NUMBER (9) */
	

	Integer holidayId;
	String holidayCd;
	String holidayName;
	Date holidayDt;
	Integer StatusInd;
	Date lastModifiedDt;
	Integer modifyPersonNum;
	
	public Holiday() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Holiday(Integer holidayId, String holidayCd, String holidayName, Date holidayDt, Integer statusInd,
			Date lastModifiedDt, Integer modifyPersonNum) {
		super();
		this.holidayId = holidayId;
		this.holidayCd = holidayCd;
		this.holidayName = holidayName;
		this.holidayDt = holidayDt;
		StatusInd = statusInd;
		this.lastModifiedDt = lastModifiedDt;
		this.modifyPersonNum = modifyPersonNum;
	}


	public Integer getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(Integer holidayId) {
		this.holidayId = holidayId;
	}
	public String getHolidayCd() {
		return holidayCd;
	}
	public void setHolidayCd(String holidayCd) {
		this.holidayCd = holidayCd;
	}
	public String getHolidayName() {
		return holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}
	public Date getHolidayDt() {
		return holidayDt;
	}
	public void setHolidayDt(Date holidayDt) {
		this.holidayDt = holidayDt;
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
		result = prime * result + ((holidayId == null) ? 0 : holidayId.hashCode());
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
		Holiday other = (Holiday) obj;
		if (holidayId == null) {
			if (other.holidayId != null)
				return false;
		} else if (!holidayId.equals(other.holidayId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Holiday [holidayId=" + holidayId + ", holidayCd=" + holidayCd + ", holidayName=" + holidayName
				+ ", holidayDt=" + holidayDt + ", StatusInd=" + StatusInd + ", lastModifiedDt=" + lastModifiedDt
				+ ", modifyPersonNum=" + modifyPersonNum + "]";
	}
	
	


}
