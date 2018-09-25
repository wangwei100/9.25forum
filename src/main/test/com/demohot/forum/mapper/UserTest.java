package com.demohot.forum.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demohot.forum.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:app-context.xml" })
public class UserTest {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BbsMapper bbsMapper;

	private Date newDate;

	@Test
	public void insertTest() {
		User user = new User();
		user.setUsername("qq");
		user.setPassword("111111");
		userMapper.insert(user);
	}

//	 @SuppressWarnings("deprecation")
//	 @Test
//	 public void insertBbsTest() {
//	 // Date date = new Date();
//	 Bbs bbs = new Bbs();
//	 bbs.setTitle("222");
//	 bbs.setContent("eee");
//	 // date.setTime(new Date().getTime() + 60 * 60 * 1000);
//	 bbs.setTime(new Date().getDate() + 60 * 60 * 1000);
//	 bbsMapper.insert(bbs);
//	 }

//	@Test
//	public Date insertTest(Date date, int i) {
//		Bbs bbs = new Bbs();
//		bbs.setTitle("222");
//		bbs.setContent("eee");
//		Calendar c = Calendar.getInstance();
//		bbs.setTime(newDate);
//		c.setTime(date);
//		c.add(Calendar.HOUR_OF_DAY, 3);
//		Date newDate = c.getTime();
//		return newDate;
//		bbsMapper.insert(bbs);
//	}
}
