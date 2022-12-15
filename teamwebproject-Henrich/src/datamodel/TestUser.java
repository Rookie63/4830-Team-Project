package datamodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestUser {

	@Test
	void testGetId()
	{
		User user1 = new User(1, "user1", "user1");
		int expected = 1;
		int actual = user1.getId();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testsetId() {
		User user1 = new User(1, "user1", "user1");
		
		user1.setId(6);
		assertEquals(6, user1.getId());
	}
	
	@Test
	void testGetUsername()
	{
		User user1 = new User(1, "user1", "user1");
		String expected = "user1";
		String actual = user1.getUsername();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetUsername()
	{
		User user1 = new User(1, "user1", "user1");
		
		user1.setUsername("newName");
		
		assertEquals("newName", user1.getUsername());
	}
	
	@Test
	void testGetPassword()
	{
		User user1 = new User(1, "user1", "user1");
		String expected = "user1";
		String actual = user1.getPassword();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSetPassword()
	{
		User user1 = new User(1, "user1", "user1");
		
		user1.setPassword("newpassword");
		
		assertEquals("newpassword", user1.getPassword());
	}
	
	@Test
	void testGetAdmin()
	{
		User user1 = new User(1, "user1", "user1");
		int expected = 0;
		int actual = user1.getAdmin();
		
		assertEquals(expected, actual);
	}
	
	@Test 
	void testSetAdmin()
	{
		User user1 = new User(1, "user1", "user1");
		
		user1.setAdmin(1);
		
		assertEquals(1, user1.getAdmin());
	}
	
	@Test
	void testToString()
	{
		User user1 = new User(1, "user1", "user1");
		String expected = "User: 1, user1";
		String actual = user1.toString();
		
		assertEquals(expected, actual);
	}
}
