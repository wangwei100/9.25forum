package com.demohot.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.forum.model.Bbs;

public interface BbsMapper {
	void insert(Bbs bbs);

	void delete(Bbs bbs);

	void update(Bbs bbs);

	List<Bbs> list();

	Bbs get(@Param("id") Integer id);

	List<Bbs> getByTitle(@Param("title") String title, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);

	int countByTitle(@Param("title") String title);

	List<Bbs> getById(Integer id);
}
