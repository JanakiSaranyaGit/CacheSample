package cache.CacheClient;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import cache.cacheLayer.CacheLayerTest;
import cache.staticData.Country;
import cache.staticData.CountryTableDataService;
import cache.staticData.Currency;
import cache.staticData.CurrencyTableDataService;
import cache.staticData.Holiday;
import cache.staticData.HolidayTableDataService;

@Component
public class CacheClient {

	@Autowired
	public CountryTableDataService countryService;

	@Autowired
	public CurrencyTableDataService currencyService;

	@Autowired
	public HolidayTableDataService holidayService;

	@Autowired
	public CacheLayerTest cacheLayerTest;

	public static void main(String arg[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

		CacheClient client = context.getBean(CacheClient.class);
		client.action(context);

	}

	void action(ApplicationContext context) {
		System.out.println("****Action starts****");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("****Note! cache was empty****");
		testCountry(context);
		testCurrency(context);
		testHoliday(context);
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("****Action ends****");
	}

	void testCountry(ApplicationContext context) {
		System.out.println("*********************************Country Table*********************************");
		System.out.println(" Accessing DB service to test GET METHOD  ");
		System.out.println("Country Table- Accessing DB service get method first time ");
		for (Country ctry : CountryTableDataService.countryTableData.values()) {

			System.out.println(countryService.getCountryTableData(ctry.getCountryId()).toString());
		}

		// fetch second time
		System.out.println("\n\n");
		System.out.println("Country Data- Accessing DB service get method  second time ");
		for (Country ctry : CountryTableDataService.countryTableData.values()) {

			System.out.println(countryService.getCountryTableData(ctry.getCountryId()).toString());
		}
		System.out.println("No DB hit !!!!");

		// UPDATE
		Country country = CountryTableDataService.countryTableData.get(1);
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to UPDATE  ");
		country.setCountryName(country.getCountryName().concat("changed"));
		countryService.updateCountry(country);

		System.out.println("Cache entries after UPDATE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after UPDATE ************");
		for (Country ctry : CountryTableDataService.countryTableData.values()) {

			System.out.println(countryService.getCountryTableData(ctry.getCountryId()).toString());
		}

		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// INSERT
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to INSERT  ");
		Country newCountry = new Country(5, "new", "new", 1, java.sql.Date.valueOf(LocalDate.now()), 1);
		countryService.addCountry(newCountry);

		System.out.println("Cache entries after INSERT ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after INSERT ************");
		for (Country ctry : CountryTableDataService.countryTableData.values()) {

			System.out.println(countryService.getCountryTableData(ctry.getCountryId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// delete
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to Delete");
		countryService.deleteCountry(CountryTableDataService.countryTableData.get(2));
		countryService.deleteCountry(CountryTableDataService.countryTableData.get(3));
		countryService.deleteCountry(CountryTableDataService.countryTableData.get(4));

		System.out.println("Cache entries after DELETE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after delete ************");
		for (Country ctry : CountryTableDataService.countryTableData.values()) {

			System.out.println(countryService.getCountryTableData(ctry.getCountryId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");
		System.out.println("\n\n");

	}

	void testCurrency(ApplicationContext context) {

		System.out.println("****************Currency Table***************************");
		System.out.println(" Accessing DB service to test GET METHOD  ");
		System.out.println("Currency Table- Accessing DB service get method first time ");
		for (Currency curr : CurrencyTableDataService.currencyTableData.values()) {

			System.out.println(currencyService.getCurrencyTableData(curr.getCurrencyId()).toString());
		}

		// fetch second time
		System.out.println("\n\n");
		System.out.println("Currency Data- Accessing DB service get method  second time ");
		for (Currency curr : CurrencyTableDataService.currencyTableData.values()) {

			System.out.println(currencyService.getCurrencyTableData(curr.getCurrencyId()).toString());
		}
		System.out.println("No DB hit !!!!");

		// UPDATE
		Currency currency = CurrencyTableDataService.currencyTableData.get(1);
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to UPDATE  ");
		currency.setCurrencyName(currency.getCurrencyName().concat("changed"));
		currencyService.updateCurrency(currency);

		System.out.println("Cache entries after UPDATE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after UPDATE ************");
		for (Currency curr : CurrencyTableDataService.currencyTableData.values()) {

			System.out.println(currencyService.getCurrencyTableData(curr.getCurrencyId()).toString());
		}

		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// INSERT
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to INSERT  ");
		Currency newCurrency = new Currency(5, "new", "new", "new", 1, java.sql.Date.valueOf(LocalDate.now()), 1);
		currencyService.addCurrency(newCurrency);

		System.out.println("Cache entries after INSERT ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after INSERT ************");
		for (Currency curr : CurrencyTableDataService.currencyTableData.values()) {

			System.out.println(currencyService.getCurrencyTableData(curr.getCurrencyId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// delete
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to Delete");
		currencyService.deleteCurrency(CurrencyTableDataService.currencyTableData.get(2));
		currencyService.deleteCurrency(CurrencyTableDataService.currencyTableData.get(3));
		currencyService.deleteCurrency(CurrencyTableDataService.currencyTableData.get(4));

		System.out.println("Cache entries after DELETE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after delete ************");
		for (Currency curr : CurrencyTableDataService.currencyTableData.values()) {

			System.out.println(currencyService.getCurrencyTableData(curr.getCurrencyId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

	}

	void testHoliday(ApplicationContext context) {

		System.out.println("****************Holiday Table***************************");
		System.out.println(" Accessing DB service to test GET METHOD  ");
		System.out.println("Holiday Table- Accessing DB service get method first time ");
		for (Holiday day : HolidayTableDataService.holidayTableData.values()) {

			System.out.println(holidayService.getHolidayTableData(day.getHolidayId()).toString());
		}

		// fetch second time
		System.out.println("\n\n");
		System.out.println("Holiday Data- Accessing DB service get method  second time ");
		for (Holiday day : HolidayTableDataService.holidayTableData.values()) {

			System.out.println(holidayService.getHolidayTableData(day.getHolidayId()).toString());
		}
		System.out.println("No DB hit !!!!");

		// UPDATE
		Holiday holiday = HolidayTableDataService.holidayTableData.get(1);
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to UPDATE  ");
		holiday.setHolidayName(holiday.getHolidayName().concat("changed"));
		holidayService.updateHoliday(holiday);

		System.out.println("Cache entries after UPDATE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after UPDATE ************");
		for (Holiday day : HolidayTableDataService.holidayTableData.values()) {

			System.out.println(holidayService.getHolidayTableData(day.getHolidayId()).toString());
		}

		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// INSERT
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to INSERT  ");
		Holiday newHoliday = new Holiday(5, "new", "new", java.sql.Date.valueOf(LocalDate.now()), 1,
				java.sql.Date.valueOf(LocalDate.now()), 1);
		holidayService.addHoliday(newHoliday);

		System.out.println("Cache entries after INSERT ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after INSERT ************");
		for (Holiday day : HolidayTableDataService.holidayTableData.values()) {

			System.out.println(holidayService.getHolidayTableData(day.getHolidayId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

		// delete
		System.out.println("\n\n");
		System.out.println(" Accessing DB service to Delete");
		holidayService.deleteHoliday(HolidayTableDataService.holidayTableData.get(2));
		holidayService.deleteHoliday(HolidayTableDataService.holidayTableData.get(3));
		holidayService.deleteHoliday(HolidayTableDataService.holidayTableData.get(4));

		System.out.println("Cache entries after DELETE ");
		cacheLayerTest.seeCacheEntries(context);
		System.out.println("\n\n");
		System.out.println("******** invoke get method of DB service after delete ************");
		for (Holiday day : HolidayTableDataService.holidayTableData.values()) {

			System.out.println(holidayService.getHolidayTableData(day.getHolidayId()).toString());
		}
		System.out.println("Note ....No DB hit !!!! as Cache is also updated ");

	}
}
