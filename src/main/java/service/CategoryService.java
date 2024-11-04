package service;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import model.Category;
import util.HibernateUtil;

public class CategoryService implements DAO<Category> {
	private static final Logger logger = Logger.getLogger(CategoryService.class.getName());
	private SessionFactory sessionFactory = getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		}catch(Exception ex) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", ex);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}
//	add a category
	@Override
	public void add(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
		logger.info("Catygory saved successfully, Category Details="+category);
		
	}
//	update a category
	@Override
	public void update(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction(); 
		session.merge(category);
		session.getTransaction().commit();
		logger.info("category updated successfully, Category Details="+category);
	}
	
//	remove a category
	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Category category = (Category) session.getReference(Category.class, Integer.valueOf(id));
		if(null != category){
			session.remove(category);
		}
		session.getTransaction().commit();
		logger.info("Category deleted successfully, category details="+category);
	}
	
//  get a category using an id
	@Override
	public Category get(int id) {
		Session session =  this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Category category = (Category) session.getReference(Category.class, Integer.valueOf(id));
		session.getTransaction().commit();
		logger.info("Category loaded successfully, Category details="+category); 
		return category;
	}
	
//	list all the categories
	@Override
	public List<Category> list() {
		List<Category> CategoriesList = new ArrayList<>();
		System.out.println("list all categories");
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			CategoriesList = session.createQuery("select c from Category c", Category.class).list();
			session.getTransaction().commit();
			System.out.println("categorie's list size : "+CategoriesList.size());
			return CategoriesList;
		} catch (Exception e) {
			System.out.println("Error in getAllCategories\n"+e);
			e.printStackTrace();
			return CategoriesList;
		}
	}
//	selecting a category using a keyword 
	@Override
	public List<Category> selectByKeyword(String str) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Category> CategoriesList = session.createQuery("from Category c WHERE c.nom LIKE '%"+str+"%'", Category.class).list();
		session.getTransaction().commit(); 
		return CategoriesList;
	}
	
}