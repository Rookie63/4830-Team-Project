package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datamodel.User;

class TestUtilUser 
{

	@Test
	void testCreateUser() 
	{
		//UtilUser.createUser("testUser", "testUser");
	}

	@Test
	void testLogin()
	{
		//There are two admins are already in the database. They are "0" and "admin"
		//sets to 1 if 0 is an admin
		int admin1 = UtilUser.login("0", "0");
		
		//sets to 1 if admin is an admin
		int admin2 = UtilUser.login("admin", "admin");
		
		assertEquals(1, admin1);
		assertEquals(1, admin2);
	}
	
}
