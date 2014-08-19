package com.sample.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {

	private UserService us;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		UserDao ud = new UserDaoImpl();
		us = new UserService(ud);
	}

	@After
	public void tearDown() throws Exception {
		us.clearAllUsers();
	}

	@Test
	public void testCreateUser() {
		String username = "testUser";
		assertTrue(us.createUser(username));
	}
	
	@Test
	public void testContainsUser() {
		String username = "testUser";
		us.createUser(username);
		assertTrue(us.containsUser(username));
	}
	
	@Test
	public void testNumUsers() {
		int numUsersToCreate = 5;
		
		for (int i = 1; i <= numUsersToCreate; i++) {
			us.createUser("user" + i);
		}
		
		assertEquals(numUsersToCreate, us.getNumUsers());
	}
	
	@Test
	public void testSortedUsers() {
		
		String[] sortedUsers = {"user0", "user1", "user2", "user3", "user4", "user5", "user6", "user7", "user8", "user9"};
		
		
		//Need to clone the sortedUsers array, so that we can have both arrays to compare at the end of this test
		String[] shuffledUsers = sortedUsers.clone();
		
		Random r = new Random();
		for (int i = shuffledUsers.length - 1; i > 0; i--)
	    {
	      int j = r.nextInt(i + 1);

	      String temp = shuffledUsers[j];
	      shuffledUsers[j] = shuffledUsers[i];
	      shuffledUsers[i] = temp;
	    }
		
		//Create the users using the shuffled list order
		for (String s : shuffledUsers) {
			us.createUser(s);
		}
		
		String[] actualList = us.getSortedUsersList();

		assertArrayEquals(sortedUsers, actualList);
	}

	@Test
	public void testEmptySort() {
		String[] actualList = us.getSortedUsersList();
		String[] expectedList = new String[0];
		
		assertArrayEquals(expectedList, actualList);
	}
	
	@Test
	public void testNullSort() {
		us.createUser(null);
		String[] actualList = us.getSortedUsersList();
		String[] expectedList = {null};
		assertArrayEquals(expectedList, actualList);
	}
}
