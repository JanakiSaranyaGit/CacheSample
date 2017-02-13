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
public class CurrencyTableDataService {

	public static Map<Integer, Currency> currencyTableData = new HashMap<Integer, Currency>();
	
	Integer currencyId;
	String currencyCd;
	String currencyName;
	String currencySymbol;
	Integer StatusInd;
	Date lastModifiedDt;
	Integer modifyPersonNum;
	
	/* to mimic DB*/
	static {
		Integer currencyId = 1;
		char currencyCd = 'A';
		char currencyName = 'A';
		char currencySymbol = 'A';
		Integer statusInd = 1;
		LocalDate lastModifiedDt = LocalDate.now();
		Integer modifyPersonNum = 1;
		Currency currency;
		for (int i = 1; i < 5; i++) {
			currency = new Currency();
			currency.setCurrencyId(currencyId++);
			currency.setCurrencyCd(Character.toString(currencyCd++));
			currency.setCurrencyName(Character.toString(currencyName++));
			currency.setCurrencySymbol(Character.toString(currencySymbol++));
			currency.setStatusInd(statusInd++);
			currency.setLastModifiedDt(java.sql.Date.valueOf(lastModifiedDt));
			currency.setModifyPersonNum(modifyPersonNum++);
			currencyTableData.putIfAbsent(currency.getCurrencyId(), currency);
		}
	}

	/**
	 * getter method
	 * 
	 * @param currencyId
	 * @return
	 */
	@Cacheable(key = "{#root.targetClass,#currencyId}")
	public Currency getCurrencyTableData(Integer currencyId) {
		System.out.println("hit getCurrencyTableData for id" + currencyId);
		return currencyTableData.get(currencyId);
	}

	/**
	 * @param currency
	 */
	@CachePut(key = "{#root.targetClass,#currency.currencyId}")
	public Currency addCurrency(Currency currency) {
		System.out.println("hit addCurrency for id" + currency.getCurrencyId());
		currencyTableData.putIfAbsent(currency.getCurrencyId(), currency);
		return currency;
	}

	/**
	 * @param currency
	 */
	@CachePut(key = "{#root.targetClass,#currency.currencyId}")
	public Currency updateCurrency(Currency currency) {
		System.out.println("hit updateCurrency for id" + currency.getCurrencyId());
		currencyTableData.put(currency.getCurrencyId(), currency);
		return currency;
	}

	/**
	 * @param currency
	 */
	@CacheEvict(key = "{#root.targetClass,#currency.currencyId}")
	public void deleteCurrency(Currency currency) {
		System.out.println("hit deleteCurrency for id" + currency.getCurrencyId());
		if (currencyTableData.containsKey(currency.getCurrencyId())) {
			currencyTableData.remove(currency.getCurrencyId());
		}
	}

}
