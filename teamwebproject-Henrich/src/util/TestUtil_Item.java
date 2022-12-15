package util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import datamodel.Item;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestUtil_Item {
	
	@Test
	public void testListByRoom() 
	{
		Item item1 = new Item(20, "item1", "desc1", "price1", false, false, "place1", "room1");
		Item item2 = new Item(21, "item2", "desc1", "price1", false, false, "place1", "room1");
		Item item3 = new Item(22, "item3", "desc1", "price1", false, false, "place1", "room1");
		Item item4 = new Item(23, "item1", "desc1", "price1", false, false, "place1", "room1");
		Item item5 = new Item(24, "item2", "desc1", "price1", false, false, "place1", "room1");
		Item item6 = new Item(25, "item3", "desc1", "price1", false, false, "place1", "room1");
		
		List<Item> roomList = new ArrayList<Item>();
		
		roomList = Util_Item.listItemByRoom("room1");
		
		List<Item> expected = new ArrayList<Item>();
		expected.add(item1);
		expected.add(item2);
		expected.add(item3);
		expected.add(item4);
		expected.add(item5);
		expected.add(item6);
		
		for (int i = 0; i < roomList.size(); i++)
		{
			assertEquals(roomList.get(i).getName(), expected.get(i).getName());
		}
	}
	
	@Test
	public void testListByType() 
	{
		Item item1 = new Item(20, "item1", "desc1", "price1", false, false, "place1", "room1");
		Item item2 = new Item(21, "item2", "desc1", "price1", false, false, "place1", "room1");
		Item item3 = new Item(22, "item3", "desc1", "price1", false, false, "place1", "room1");
		Item item4 = new Item(23, "item1", "desc1", "price1", false, false, "place1", "room1");
		Item item5 = new Item(24, "item2", "desc1", "price1", false, false, "place1", "room1");
		Item item6 = new Item(25, "item3", "desc1", "price1", false, false, "place1", "room1");
		
		List<Item> typeList = new ArrayList<Item>();
		
		typeList = Util_Item.listItemByType("item2");
		
		List<Item> expected = new ArrayList<Item>();
		expected.add(item2);
		expected.add(item5);
		
		for (int i = 0; i < typeList.size(); i++)
		{
			assertEquals(typeList.get(i).getName(), expected.get(i).getName());
		}
	}
	
	

}
