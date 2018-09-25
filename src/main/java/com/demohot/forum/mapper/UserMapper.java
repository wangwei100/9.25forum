package com.demohot.forum.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demohot.forum.model.User;

public interface UserMapper {
	void insert(User user);

	void delete(User user);

	void update(User user);

	void updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

	User get(@Param("id") Integer id);

	User getByUsername(@Param("username") String username);

	User getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	List<User> list();
}
