package cn.demo.random.redis;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.demo.random.Application;
import cn.demo.random.rbac.domain.RbacUser;
import cn.demo.random.rbac.service.IRbacService;

@ActiveProfiles(profiles = "dev")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@IntegrationTest
//@Transactional
public class RedisTest {
	
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private IRbacService rbacService;
	@Autowired
	private RedisProperties redisProperties;
	
	@Test
	public void printRedisProperties(){
		System.out.println("------------------------------------------------------------------------");
		System.out.println("----------------------------------" + redisProperties.getHost() + "--------------------------------------");
		System.out.println("------------------------------------------------------------------------");
	}
	
	@Test
	public void baseRedisTemplateTest() {
		String productKey = "product";
		Product p = new Product("1", "Mac", "apple");
		redisTemplate.opsForValue().set(productKey, p);
		Product pb = (Product)redisTemplate.opsForValue().get(productKey);
		assertThat(pb.getId(), equalTo(p.getId()));
	}
	
	@Test
	public void baseStringRedisTemplateTest(){
		
		String key = "nimei";
		String str = "world";
		stringRedisTemplate.opsForValue().set(key, str);
		String backFromRedis = stringRedisTemplate.opsForValue().get(key);
		assertThat(backFromRedis, equalTo(str));
		
		BoundListOperations<String,String> boundListOps = stringRedisTemplate.boundListOps("list");
		boundListOps.expire(0, TimeUnit.MILLISECONDS);
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		boundListOps.rightPushAll(list.toArray(new String[]{}));
		List<String> range = boundListOps.range(0, 10);
		for(String val : range){
			System.out.println("-----------" + val + "------------");
		}
		assertThat(range, equalTo(list));
	}
	@Test
	public void testRbacUser() {
		String userName = "Josh";
		RbacUser oneByUserName = rbacService.findOneByUserName(userName);
		assertThat(userName, equalTo(oneByUserName.getUserName()));
		RbacUser userName2 = rbacService.findOneByUserName(userName);
		assertThat(userName, equalTo(userName2.getUserName()));
	}
}
