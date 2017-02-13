package cache.staticData;

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
public class CountryTableDataService {

	public static Map<Integer, Country> countryTableData = new HashMap<Integer, Country>();

	/* to mimic DB*/
	static {
		Integer countryId = 1;
		char countryCd = 'A';
		char countryName = 'A';
		Integer statusInd = 1;
		LocalDate lastModifiedDt = LocalDate.now();
		Integer modifyPersonNum = 1;
		Country country;
		for (int i = 1; i < 5; i++) {
			country = new Country();
			country.setCountryId(countryId++);
			country.setCountryCd(Character.toString(countryCd++));
			country.setCountryName(Character.toString(countryName++));
			country.setStatusInd(statusInd++);
			country.setLastModifiedDt(java.sql.Date.valueOf(lastModifiedDt));
			country.setModifyPersonNum(modifyPersonNum++);
			countryTableData.putIfAbsent(country.getCountryId(), country);
		}
	}

	/**
	 * @param countryId
	 * @return Country
	 */
	@Cacheable(key = "{#root.targetClass,#countryId}")
	public Country getCountryTableData(Integer countryId) {
		System.out.println(" I hit DB  getCountryTableData for id"+countryId);
		return countryTableData.get(countryId);
	}

	/**
	 * @param country
	 * @CachePut- always updates cache
	 */
	@CachePut(key = "{#root.targetClass,#country.countryId}")
	public Country addCountry(Country country) {
		System.out.println("hit addCountry for id"+country.getCountryId());
		countryTableData.putIfAbsent(country.getCountryId(), country);
		return country;
	}

	/**
	 * @param country
	 * @CachePut- always updates cache
	 */
	@CachePut(key = "{#root.targetClass,#country.countryId}")
	public Country updateCountry(Country country) {
		System.out.println("I hit DB  to updateCountry for id"+country.getCountryId());
		countryTableData.put(country.getCountryId(), country);
		return country;
	}

	/**
	 * @param country
	 * @CacheEvict- removes from  cache
	 */
	@CacheEvict(key = "{#root.targetClass,#country.countryId}")
	public void deleteCountry(Country country) {
		System.out.println("I hit DB to deleteCountry for id"+country.getCountryId());
		if (countryTableData.containsKey(country.getCountryId())) {
			countryTableData.remove(country.getCountryId());
		}
	}

}
