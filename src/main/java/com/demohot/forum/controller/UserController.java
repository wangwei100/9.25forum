package com.demohot.forum.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demohot.forum.controller.Vo.BbsVo;
import com.demohot.forum.mapper.BbsMapper;
import com.demohot.forum.mapper.UserMapper;
import com.demohot.forum.model.Bbs;
import com.demohot.forum.model.PageBean;
import com.demohot.forum.model.User;

@Controller
public class UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BbsMapper bbsMapper;

	@RequestMapping("/user/home")
	public ModelAndView home(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "3") Integer pageSize, String title, HttpSession session) {
		if ("".equals(title)) {
			title = null;
		}
		ModelAndView mv = new ModelAndView();
		int offset = (pageNum - 1) * pageSize;
		List<Bbs> list = bbsMapper.getByTitle(title, offset, pageSize);
		int totalRecord = bbsMapper.countByTitle(title);
		int totalPage = (int) Math.ceil((double) totalRecord / pageSize);
		List<BbsVo> bbsVoList = new ArrayList<>();
		for (Bbs bbs : list) {
			BbsVo bbsVo = new BbsVo();
			bbsVo.setId(bbs.getId());
			bbsVo.setTitle(bbs.getTitle());
			bbsVo.setContent(bbs.getContent());
			bbsVo.setTime(bbs.getTime());

			User user = userMapper.get(bbs.getId());
			bbsVo.setOwner(user.getUsername());
			bbsVoList.add(bbsVo);
		}
		mv.setViewName("/user/home.jsp");
		PageBean<BbsVo> bbsPage = new PageBean<BbsVo>();
		bbsPage.setList(bbsVoList);
		bbsPage.setPageNum(pageNum);
		bbsPage.setPageSize(pageSize);
		bbsPage.setTotalPage(totalPage);
		bbsPage.setTotalRecord(totalRecord);
		mv.addObject("bbsPage", bbsPage);
		mv.addObject("title", title);
		return mv;
	}

	@RequestMapping("/user/publish")
	public ModelAndView publish(HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		ModelAndView mv = new ModelAndView("/user/publish.jsp");
		return mv;
	}

	@RequestMapping("/user/do_publish")
	public ModelAndView doPublish(String title, String content, Date time, HttpSession session) {
		// 判断用户登录
		User hasUser = (User) session.getAttribute("loginUser");
		if (null == hasUser) {
			return new ModelAndView("redirect:/user/login");
		}
		Map<String, Object> model = new HashMap<>();
		model.put("title", title);
		model.put("content", content);
		if (null == title || "".equals(title)) {
			// 标题为空
			model.put("titleMessage", "标题不能为空");
			return new ModelAndView("/user/publish.jsp", model);
		}
		if (null == content || "".equals(content)) {
			// 内容为空
			model.put("contentMessage", "内容不能为空");
			return new ModelAndView("/user/publish.jsp", model);
		}
		// Date date = new Date();
		// date.setHours(new Date().getHours() + 3);
		Bbs bbs = new Bbs();
		bbs.setTitle(title);
		bbs.setContent(content);
		bbs.setTime(new Date());
		bbsMapper.insert(bbs);
		return new ModelAndView("redirect:/user/home");
	}
}
