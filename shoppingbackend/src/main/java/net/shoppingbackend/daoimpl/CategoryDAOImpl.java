package net.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.shoppingbackend.dao.CategoryDAO;
import net.shoppingbackend.dto.Category;
import net.shoppingbackend.dto.Product;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	// getting single category based on id
	@Override
	public Category get(int id) {
		try{
			return sessionFactory
				.getCurrentSession()
					.get(Category.class, Integer.valueOf(id));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			// add the category to the database table
			
			sessionFactory
				.getCurrentSession()
					.persist(category);
			return true;	
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			
			sessionFactory
				.getCurrentSession()
					.update(category);
			return true;	
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// delete the category from the database table
			
			sessionFactory
				.getCurrentSession()
					.update(category);
			return true;	
			
		}
		catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
		
	}

}
