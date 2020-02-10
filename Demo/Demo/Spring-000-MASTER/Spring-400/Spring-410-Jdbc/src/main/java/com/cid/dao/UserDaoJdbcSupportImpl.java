package com.cid.dao;

import static com.cid.dao.Queries.USER_BY_ID;
import static com.cid.dao.Queries.USER_BY_TEAM_ID;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cid.dao.helpers.UserRowMapper;
import com.cid.model.User;

@Repository()
public class UserDaoJdbcSupportImpl extends JdbcDaoSupport implements UserDao{

	
	@Autowired
	private UserRowMapper userRowMapper;
	
	@Autowired
	private DataSource dataSource;	
	
	@PostConstruct
	public void init(){
		this.setDataSource(dataSource);
	}
	
	@Override
	public User findById(int id) {
		return getJdbcTemplate().queryForObject(USER_BY_ID,new Object[] { id }, userRowMapper);	
	}

	@Override
	public List<User> findByTeamId(int teamId) {
		return getJdbcTemplate().query(USER_BY_TEAM_ID,new Object[] { teamId }, userRowMapper);	
	}
	
	@Override
	public void createUser(User newUser) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void loadAllUsers() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void updateUser(int id, User userToUpdate) {
		// TODO Auto-generated method stub		
	}

}
