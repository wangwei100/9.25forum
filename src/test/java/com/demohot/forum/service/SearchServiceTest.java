package com.demohot.forum.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:app-context.xml" })
public class SearchServiceTest implements SearchService {
	@Autowired
	private SearchService searchService;

	@Test
	public void index() {
		// SolrInputDocument doc = new SolrInputDocument();
		// doc.addField("id", "58");
		// doc.addField("user_id", "2");
		// doc.addField("title", "uuuuuu");
		// doc.addField("content", "shuaksjdha");
		// doc.addField("time", date1);
		searchService.index();

		System.out.println("done");
	}

	@Test
	public void search() {
		searchService.search();
	}

}
