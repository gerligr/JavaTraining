package com.cid.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

import static com.cid.dao.Queries.USER_BY_ID;
import static com.cid.dao.Queries.USER_BY_TEAM_ID;

@Repository
public class UserDaoJdbcTemplate implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserRowMapper userRowMapper;	
	
	@Override
	public User findById(int id) {
		return jdbcTemplate.queryForObject(USER_BY_ID,new Object[] { id }, userRowMapper);			
	}

	@Override
	public List<User> findByTeamId(int teamId) {		
		return jdbcTemplate.query(USER_BY_TEAM_ID,new Object[] { teamId }, userRowMapper);	
	}

	@Override
	public void createUser(User newUser) {
		throw new UnsupportedOperationException("Not yet implemented");		
	}

	@Override
	public void loadAllUsers() {
		throw new UnsupportedOperationException("Not yet implemented");			
	}

	@Override
	public void deleteUser(int id) {
		throw new UnsupportedOperationException("Not yet implemented");		
	}
	
	@Override
	public void updateUser(int id, User userToUpdate) {
		throw new UnsupportedOperationException("Not yet implemented");	
	}

	

}
