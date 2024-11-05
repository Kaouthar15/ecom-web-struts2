package service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Product;
import model.Product;
import util.HibernateUtil;

public class ProductService implements DAO<Product> {
	private static final Logger logger = Logger.getLogger(ProductService.class.getName());
	private SessionFactory sessionFactory = getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		}catch(Exception ex) {
			logger.log(Level.SEVERE," Could Not create SessionFactory",ex);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}

	@Override
	public Product get(int id) {
		Session session =  this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product category = (Product) session.getReference(Product.class, Integer.valueOf(id));
		session.getTransaction().commit();
		logger.info("Category loaded successfully, Category details="+category); 
		return category;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> selectByKeyword(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}
}
