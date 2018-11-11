package com.demohot.forum.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demohot.forum.mapper.BbsMapper;
import com.demohot.forum.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private BbsMapper bbsMapper;

	@SuppressWarnings("unused")
	@Override
	public void index() {
		// Bbs bbs = new Bbs();
		try {
			final HttpSolrClient client = getSolrClient();
			final SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", UUID.randomUUID().toString());
			doc.addField("name", "Amazon Kindle Paperwhite");
			// doc.addField("user_id", bbs.setId(loginUser.getId()));
			// // doc.addField("title", bbs.setTitle(title));
			// bbs.setContent(bbs.getContent());
			// bbs.setTitle(bbs.getTitle());
			// bbs.setUser_id(bbs.getUser_id());
			// bbs.setTime(bbs.getTime());
			final UpdateResponse updateResponse = client.add("mycore", doc);
			// bbsMapper.insert(bbs);
			client.commit("mycore");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void search() {
		try {
			final SolrClient client = getSolrClient();

			final Map<String, String> queryParamMap = new HashMap<String, String>();
			queryParamMap.put("q", "*:*");
			queryParamMap.put("fl", "id, name");
			queryParamMap.put("sort", "id asc");
			MapSolrParams queryParams = new MapSolrParams(queryParamMap);
			final QueryResponse response = client.query("mycore", queryParams);
			final SolrDocumentList documents = response.getResults();

			System.out.println("Found " + documents.getNumFound() + " documents");
			for (SolrDocument document : documents) {
				final String id = (String) document.getFirstValue("id");
				final String name = (String) document.getFirstValue("name");
				System.out.println("id:" + id + ";name:" + name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpSolrClient getSolrClient() {
		final String solrUrl = "http://localhost:8983/solr";
		return new HttpSolrClient.Builder(solrUrl).withConnectionTimeout(10000).withSocketTimeout(60000).build();
	}

}
