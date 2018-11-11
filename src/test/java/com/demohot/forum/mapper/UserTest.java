package com.demohot.forum.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demohot.forum.model.Bbs;
import com.demohot.forum.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:app-context.xml" })
public class UserTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BbsMapper bbsMapper;

	@Test
	public void insertTest() {
		User user = new User();
		user.setUsername("qq");
		user.setPassword("111111");
		userMapper.insert(user);
	}

	@Test
	public void insertTest1() {
		Date date1 = new Date();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 3);
		date1 = c.getTime();
		Bbs bbs = new Bbs();
		bbs.setUser_id("3");
		bbs.setTitle("sss");
		bbs.setContent("qqqqqeasdas");
		bbs.setTime(date1);
		bbsMapper.insert(bbs);
	}

	@Test
	public void keyWordTest() {
		Bbs bbs = new Bbs();
		String keyWord = "%2%";
		bbs.setTitle("2");
		List<Bbs> list = bbsMapper.getByKeyWord(keyWord);
		for (Bbs bbs1 : list) {
			System.out.println(bbs1.getId());
			System.out.println(bbs1.getTitle());
		}
	}
}
