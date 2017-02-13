# CacheSample
This is a sample implementation to use Spring/JSR 107 api with any cache store say Echache or Infinispan.
To change the cache store , change the property in application.properties and replace the corresponding jars in classpath . 
No change is required neither in spring beans xml nor in code.
Never place more than one caching provider  jar in the class path for this sample to work

Implementation:

Api  used :
1)Spring for Dependency injection and caching 
2)Javax caching api 
3)Cache store based on the need – I tried both with ehcache and infinispan  (just to see how easy to change the cache store without code change )

Points to highlight :
>Spring Caching annotations were used on the CRUD operation methods in DB service classes 
>Spring caching annotations are JSR 107 compliant .Hence they can also be easily interchanged with javax caching api , if we don’t use spring . But as most of the applications use Spring , its better to use the advantage of caching features provided by Spring 
> The cache store name is configured in the application properties files and passed to JCacheManagerFactoryBean  in spring- beans .xml. This  is the tweak  i added to change the cache store easily . The corresponding and necessary cache store jars should be replaced in the class path . No change is required neither in spring beans xml nor in code
>We can use Javax caching api to get a glimpse of the entries in Cache for our testing .

