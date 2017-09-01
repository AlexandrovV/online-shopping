package net.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.shoppingbackend.dao.CategoryDAO;
import net.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		
//		category.setName("Mobiles");
//		category.setDescription("This is some description for mobiles!");
//		category.setImageURL("CAT_3.png");
//		
//		assertEquals("Something went wrong", true, categoryDAO.add(category));
//		
//	}
	
//	@Test
//	public void testGetCategory() {
//		
//		category = categoryDAO.get(3);
//		
//		assertEquals("Something went wrong", "Mobiles", category.getName());
//		
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		
//		category = categoryDAO.get(1);
//		
//		category.setName("TV");
//		
//		assertEquals("Something went wrong", true, categoryDAO.update(category));
//		
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		
//		category = categoryDAO.get(3);
//		
//		assertEquals("Something went wrong", true, categoryDAO.delete(category));
//		
//	}
//	
//	@Test
//	public void testListCategory() {
//		
//		assertEquals("Something went wrong", 2, categoryDAO.list().size());
//		
//	}
	
	@Test
	public void testCRUDCategory() {
		
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Something went wrong", true, categoryDAO.add(category));
		
		
		//fetching and upadting
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Something went wrong", true, categoryDAO.update(category));
		
		assertEquals("Something went wrong", true, categoryDAO.delete(category));
		
		assertEquals("Something went wrong", 1, categoryDAO.list().size());
		
	}
	
}
