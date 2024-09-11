package rikkei.academy.service;

import java.util.List;

    public interface IGenericService <T,E> {
        public List<T> selectAll();
        public T select(E id);
        public void insert(T t);
        public void update(T t);
        public void delete(E id);
    }

