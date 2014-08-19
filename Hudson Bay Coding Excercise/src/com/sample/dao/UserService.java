package com.sample.dao;

import java.util.Arrays;
import java.util.List;

public class UserService {
	
	private UserDao ud;
	
	public UserService(UserDao ud) {
		this.ud = ud;
	}
	
	public void setUserDao(UserDao ud) {
		this.ud = ud;
	}
	
	public UserDao getUserDao() {
		return ud;
	}
	
	public boolean createUser(String username) {
		return ud.add(username);
	}
		
	public int getNumUsers() {
		return ud.show().size();
	}
	
	public String[] getSortedUsersList() {
		String[] ret = Arrays.copyOf(ud.show().toArray(), ud.show().size(), String[].class);
		Arrays.sort(ret);
		return ret;
	}
	
	public boolean containsUser(String username) {
		return ud.show().contains(username);
	}
	
	public void clearAllUsers() {
		ud.show().clear();
	}
}
