package net.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.shoppingbackend.dao.UserDAO;
import net.shoppingbackend.dto.Address;
import net.shoppingbackend.dto.Cart;
import net.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		// link the user with the address using user id
//		
//		address.setUserId(user.getId());
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			cart = new Cart();
//			cart.setUser(user);
//			
//			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//			
//			address = new Address();
//			address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//			address.setAddressLineTwo("Near Kaabil Store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			
//			address.setUserId(user.getId());
//			
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		}
//	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//	
//		
//		if(user.getRole().equals("USER")) {
//			cart = new Cart();
//			cart.setUser(user);
//			
//			// attach cart with the user
//			user.setCart(cart);
//		}
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//	}
	
//	@Test
//	public void testUpdateCart() {
//		// fetch the user by email
//		user = userDAO.getByEmail("hr@gmail.com");
//		// get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		
//		assertEquals("Failed to update the cart", true, userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		// link the user with the address using user id
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//			
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//
//	}
	
//	@Test
//	public void testAddAddress() {
//		
//		user = userDAO.getByEmail("hr@gmail.com");
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Bandalore");
//		address.setState("Karnataka");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//	}
//	
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Failed to fetch the list of addressess and size does not match", 2, userDAO.listShippingAddresses(user).size());
		assertEquals("Failed to fetch the billing address and size does not match", "Mumbai", userDAO.getBillingAddress(user).getCity());
	}
}
