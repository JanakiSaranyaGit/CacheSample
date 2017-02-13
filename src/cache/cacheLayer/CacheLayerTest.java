package cache.cacheLayer;

import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.CacheManager;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CacheLayerTest {

	/**
	 * @param context
	 *            This method is used to see the entries in the Cache - Just for
	 *            the developer verification
	 */
	public void seeCacheEntries(ApplicationContext context) {
		System.out.println("****Cache entry begins******");
		CacheManager factory = (CacheManager) context.getBean("jCacheManager");
		Cache<Object, Object> cache = factory.getCache("tableCache");
		Iterator cacheIter = cache.iterator();
		while (cacheIter.hasNext()) {
			Entry entry = (Entry) cacheIter.next();
			System.out.println("Cache Entry key" + entry.getKey().toString());
			System.out.println("Cache Entry value" + entry.getValue().toString());

		}
		System.out.println("****Cache entry ends******");
	}
}
