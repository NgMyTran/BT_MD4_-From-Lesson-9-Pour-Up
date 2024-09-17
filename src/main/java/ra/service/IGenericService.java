package ra.service;

import java.util.List;

public interface IGenericService <T,E>{
    public List<T> findAll();
    public T findById(E id);
    public void save(T t);
    public void delete(E id);
}
