package service;

import java.util.List;

public interface DAO<T> {
    T get(int id);

    List<T> list();

    void add(T t);

    void update(T t);

	void remove(int id);
		
	List<T> selectByKeyword(String str);
	
	
}
