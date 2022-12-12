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
	public void testUtilItem() {
		 List<Item> resultList = new ArrayList<Item>();
		 List<Item> resultList2 = new ArrayList<Item>();
		 Item item = new Item(3, "Blender", "It's a Blender", "$5.00", false, false, "Kearney", "Kitchen");
		 assertEquals(item.getName(), "Blender");
	}

}
