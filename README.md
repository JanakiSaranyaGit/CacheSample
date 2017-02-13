# CacheSample
This is a sample implementation to use Spring/JSR 107 api with any cache store say Echache or Infinispan.
To change the cache store , change the property in application.properties and replace the corresponding jars in classpath . 
No change is required neither in spring beans xml nor in code.
Never place more than one caching provider  jar in the class path for this sample to work
