package util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import datamodel.Item;

public class Cart {

	
	public static ArrayList<Item> getCart(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ArrayList<Item> ret;
		ret = (ArrayList<Item>)session.getAttribute("cart");
		return ret;
	}
	
	public static void addItem(HttpServletRequest request, Item it)
	{
		HttpSession session = request.getSession();
		ArrayList<Item> ret = getCart(request);
		ret.add(it);
		session.setAttribute("cart", ret);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
