package net.shoppingbackend.dao;

import java.util.List;

import net.shoppingbackend.dto.Address;
import net.shoppingbackend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);
	// add an address
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
}