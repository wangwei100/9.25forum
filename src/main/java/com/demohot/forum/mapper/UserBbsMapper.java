package com.demohot.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.forum.model.UserBbs;

public interface UserBbsMapper {
	void insert(UserBbs ub);

	void delete(UserBbs ub);

	void update(UserBbs ub);

	UserBbs get(@Param("id") Integer id);

	UserBbs getByUserIdBbsId(@Param("user_id") Integer id, @Param("bbs_id") Integer bbs_id);

	int countByUserId(@Param("user_id") Integer user_id);

	List<UserBbs> getById(Integer id);

	int getTotalRecord();
}
