package rikkei.acedemy;

import java.util.List;

public interface IGenericService <T, E>{
    List<T> getAll();
    public T findById(E id);
    public void create(T t);
    public void update(T t);
    public void delete(E id);
}
