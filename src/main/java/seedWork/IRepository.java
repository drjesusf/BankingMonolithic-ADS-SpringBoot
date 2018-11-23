package seedWork;

public interface IRepository<T> {
	T get(int id);
	T get(long id);
	void saveOrUpdate(T entity);
	void delete(T entity);
}

