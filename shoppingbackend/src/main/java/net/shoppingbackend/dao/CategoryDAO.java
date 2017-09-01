package net.shoppingbackend.dao;

import java.util.List;

import net.shoppingbackend.dto.Category;
import net.shoppingbackend.dto.Product;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
