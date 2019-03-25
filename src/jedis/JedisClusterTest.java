package jedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterTest {
	@Test
	public void jedisClusterTest() throws IOException{
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("101.201.238.116", 7001));
		nodes.add(new HostAndPort("101.201.238.116", 7002));
		nodes.add(new HostAndPort("101.201.238.116", 7003));
		nodes.add(new HostAndPort("101.201.238.116", 7004));
		nodes.add(new HostAndPort("101.201.238.116", 7005));
		nodes.add(new HostAndPort("101.201.238.116", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("test", "hello world");
		String result = jedisCluster.get("test");
		System.out.println(result);
		jedisCluster.close();
	}

}
