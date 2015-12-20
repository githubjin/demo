package cn.demo.random.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 *  spring-dev-tool + spring data redis + case to same class exception
 *  workaround : https://github.com/spring-projects/spring-boot/issues/3805
 *  			 https://jira.spring.io/browse/DATAREDIS-427
 * @author Yo
 *
 */

@Configuration
@EnableCaching
//@AutoConfigureAfter(value = {MetricsConfiguration.class, DatabaseConfiguration.class})
public class CacheConfiguration {
	
	
	/** implements RedisSerializer
	 * 1 Spring data redis comes with several such serializers, including these
	 * 2 GenericToStringSerializer Serializes using a Spring conversion service
	 * 3 JacksonJsonRedisSerializer Serializes objects to JSON using Jackson 1
	 * 4 Jackson2JsonredisSerializer Serializes objects ro Json using Jackson 2
	 * 5 JdkSerializationRedisSerializer Use Java serialization
	 * 6 OxmSerializer Serializes using marshalers and unmarshalers from Spring's O/X mapping.for xml serialization.
	 * 7 StringRedisSerializer Serializes String keys and values
	 * ResdisTemplate uses 5 
	 * StringRedisTemplate uses 7
	 */
	
	@Bean
	public RedisTemplate<Object, Object> refisTemplate(RedisConnectionFactory cf){
		RedisTemplate<Object, Object> redis = new RedisTemplate<Object, Object>();
		redis.setConnectionFactory(cf);
		redis.setKeySerializer(new StringRedisSerializer());
		redis.setValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
		return redis;
	}
}
