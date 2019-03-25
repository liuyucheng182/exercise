package jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void jedisTest(){
		Jedis jedis = new Jedis("101.201.238.116", 6379);
		jedis.set("jedis", "jedis test");
		String result = jedis.get("jedis");
		System.out.println(result);
		jedis.close();
	}
	
	//jedis连接池
	@Test
	public void jedisPoolTest(){
		JedisPool jedisPool = new JedisPool("101.201.238.116", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.set("jedisPool", "jedisPool test");
		String result = jedis.get("jedisPool");
		System.out.println(result);
		jedis.close();
		jedisPool.close();
	}
}
