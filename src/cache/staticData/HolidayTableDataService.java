package cache.staticData;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "tableCache")
public class HolidayTableDataService  {


	public static Map<Integer, Holiday> holidayTableData = new HashMap<Integer, Holiday>();

	Integer holidayId;
	String holidayCd;
	String holidayName;
	String holidaySymbol;
	Integer StatusInd;
	Date lastModifiedDt;
	Integer modifyPersonNum;
	
	/* to mimic DB*/
	static {
		Integer holidayId = 1;
		char holidayCd = 'A';
		char holidayName = 'A';
		LocalDate holidayDt= LocalDate.now();
		Integer statusInd = 1;
		LocalDate lastModifiedDt = LocalDate.now();
		Integer modifyPersonNum = 1;
		Holiday holiday;
		for (int i = 1; i < 5; i++) {
			holiday = new Holiday();
			holiday.setHolidayId(holidayId++);
			holiday.setHolidayCd(Character.toString(holidayCd++));
			holiday.setHolidayName(Character.toString(holidayName++));
			holiday.setHolidayDt(java.sql.Date.valueOf(holidayDt));
			holiday.setStatusInd(statusInd++);
			holiday.setLastModifiedDt(java.sql.Date.valueOf(lastModifiedDt));
			holiday.setModifyPersonNum(modifyPersonNum++);
			holidayTableData.putIfAbsent(holiday.getHolidayId(), holiday);
		}
	}

	/**
	 * getter method
	 * 
	 * @param holidayId
	 * @return
	 */
	@Cacheable(key = "{#root.targetClass,#holidayId}")
	public Holiday getHolidayTableData(Integer holidayId) {
		System.out.println("hit getHolidayTableData for id" + holidayId);
		return holidayTableData.get(holidayId);
	}

	/**
	 * @param holiday
	 */
	@CachePut(key = "{#root.targetClass,#holiday.holidayId}")
	public Holiday addHoliday(Holiday holiday) {
		System.out.println("hit addHoliday for id" + holiday.getHolidayId());
		holidayTableData.putIfAbsent(holiday.getHolidayId(), holiday);
		return holiday;
	}

	/**
	 * @param holiday
	 */
	@CachePut(key = "{#root.targetClass,#holiday.holidayId}")
	public Holiday updateHoliday(Holiday holiday) {
		System.out.println("hit updateHoliday for id" + holiday.getHolidayId());
		holidayTableData.put(holiday.getHolidayId(), holiday);
		return holiday;
	}

	/**
	 * @param holiday
	 */
	@CacheEvict(key = "{#root.targetClass,#holiday.holidayId}")
	public void deleteHoliday(Holiday holiday) {
		System.out.println("hit deleteHoliday for id" + holiday.getHolidayId());
		if (holidayTableData.containsKey(holiday.getHolidayId())) {
			holidayTableData.remove(holiday.getHolidayId());
		}
	}



}
