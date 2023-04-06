package org.art.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudRepository<K, E> {

    List<E> getAll();

    E getById(K id);

    boolean delete(E entity);

    boolean update(E entity);

    boolean create(E entity);
}
