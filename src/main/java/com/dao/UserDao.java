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
		stmt.update("insert into users(firstName,lastName,email,password) values (?,?,?,?)", user.getFirstName(),
				user.getLastName(), user.getEmail(), user.getPassword());

	}

	//select -> n records -> query 
	public  List<UserBean> getAllUsers() {
		
		List<UserBean> users = stmt.query("select * from users",new BeanPropertyRowMapper<>(UserBean.class));
		return users; 
	}

}