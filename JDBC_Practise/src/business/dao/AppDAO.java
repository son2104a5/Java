package business.dao;

import java.util.List;

public interface AppDAO<T> {
    List<T> findAllByPage(int page);
    boolean save(T t);
    boolean update(T t);
    boolean delete(T t);
}
