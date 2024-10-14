package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		// update() -> insert update delete
		stmt.update("insert into users(firstName,lastName,email,password,profilePicPath) values (?,?,?,?,?)", user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getPassword(),user.getProfilePicPath());

	}

	// select -> n records -> query
	public List<UserBean> getAllUsers() {

		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<>(UserBean.class));
		return users;
	}

	public void deleteByUserId(Integer userId) {
		stmt.update("delete from users where userId = ?", userId);
	}

	public UserBean getByUserId(Integer userId) {
		// select
		UserBean user = stmt.queryForObject("select * from users where userId = ?",
				new BeanPropertyRowMapper<>(UserBean.class), new Object[] { userId });
		return user;
	}

	public void updateUser(UserBean user) {
		stmt.update("update users set firstName = ? , lastName = ? where userId = ?", user.getFirstName(),
				user.getLastName(), user.getUserId());
	}

	public UserBean getUserByEmail(String email) {
		// TODO Auto-generated method stub
		UserBean user = stmt.queryForObject("select * from users where email = ?",
				new BeanPropertyRowMapper<>(UserBean.class), new Object[] { email });
		return user;
	}

}
