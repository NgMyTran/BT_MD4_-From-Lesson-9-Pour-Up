package ra.dao;

import java.util.List;

public interface IGenericDao <T,E>{
    public List<T> findAll();
    public T findById(E id);
    public void create(T t);
    public void update(T t);
    public void delete(E id);
}
