/**
 * 
 */
package com.yihaomen.dao;

import static org.junit.Assert.*;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.yihaomen.model.User;
import com.yihaomen.model.UserExample;
import com.yihaomen.model.UserExample.Criteria;

/**
 * @author Administrator
 *
 */
public class UserMapperTest {
private SqlSession session;
private UserMapper userMapper;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		String resource = "com/yihaomen/conf.xml";
        Reader reader = Resources.getResourceAsReader(resource); 
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
         session = sessionFactory.openSession();
         userMapper=session.getMapper(UserMapper.class);
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#countByExample(com.yihaomen.model.UserExample)}.
	 */
	@Test
	public void testCountByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#deleteByExample(com.yihaomen.model.UserExample)}.
	 */
	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#deleteByPrimaryKey(java.lang.Integer)}.
	 */
	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#insert(com.yihaomen.model.User)}.
	 */
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#insertSelective(com.yihaomen.model.User)}.
	 */
	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#selectByExample(com.yihaomen.model.UserExample)}.
	 */
	@Test
	public void testSelectByExample() {
		UserExample example=new UserExample();
		example.createCriteria().andIdGreaterThan(0).andUseraddressLike("%京%")
		.andUserageBetween(10, 30);
		List<User> users=userMapper.selectByExample(example);
		System.out.println(users.size());
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#selectByPrimaryKey(java.lang.Integer)}.
	 */
	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#updateByExampleSelective(com.yihaomen.model.User, com.yihaomen.model.UserExample)}.
	 */
	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#updateByExample(com.yihaomen.model.User, com.yihaomen.model.UserExample)}.
	 */
	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#updateByPrimaryKeySelective(com.yihaomen.model.User)}.
	 */
	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yihaomen.dao.UserMapper#updateByPrimaryKey(com.yihaomen.model.User)}.
	 */
	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
