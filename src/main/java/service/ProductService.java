package service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
	
//	getting a product using its id 
	@Override
	public Product get(int id) {
		Session session =  this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product product = (Product) session.getReference(Product.class, Integer.valueOf(id));
		session.getTransaction().commit();
		logger.info("Product loaded successfully, Product details="+product); 
		return product;
	}
//	listing all the products
	@Override
	public List<Product> list() {
		List<Product> productsList = new ArrayList<>();
		System.out.println("list all products");
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			productsList = session.createQuery("select c from Product c", Product.class).list();
			session.getTransaction().commit();
			System.out.println("product's list size : "+productsList.size());
			return productsList;
		} catch (Exception e) {
			System.out.println("Error in getAllCategories\n"+e);
			e.printStackTrace();
			return productsList;
		}
	}
//	adding a product 
	@Override
	public void add(Product product) {
		System.out.println("add product method");
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(product); 
		session.getTransaction().commit();
		logger.info("Product saved successfully, Category Details="+product);
		
	}
//	update a product 
	@Override
	public void update(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();  
		session.merge(product);
		session.getTransaction().commit();
		logger.info("product updated successfully, Product Details="+product);
	}
//	selecting a product using a keyword 
	@Override
	public List<Product> selectByKeyword(String str) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Product> productsList = session.createQuery("from Product c WHERE c.nom LIKE '%"+str+"%'", Product.class).list();
		session.getTransaction().commit(); 
		return productsList;
	}
//	removing a product
	@Override
	public void remove(Long id) {
		System.out.println("remove product");
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Product product = (Product) session.getReference(Product.class, Long.valueOf(id));
		if(null != product){
			session.remove(product);
		}
		session.getTransaction().commit();
		logger.info("Product deleted successfully, product details="+product);
		
	}
}
