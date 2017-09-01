package net.shoppingbackend.dao;


import java.util.List;

import net.shoppingbackend.dto.Cart;
import net.shoppingbackend.dto.CartLine;

public interface CartLineDAO {
	// the common methods from previously coded one
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// other business method related to the cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	
	// udpate a cart
	boolean updateCart(Cart cart);	
	
}