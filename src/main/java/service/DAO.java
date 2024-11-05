package service;

import java.util.List;

import model.Product;

public interface DAO<T> {
    T get(Long id);

    List<T> list();

    void add(T t);

    void update(T t);
		
	List<T> selectByKeyword(String str);

	void remove(Long id);

	
}
