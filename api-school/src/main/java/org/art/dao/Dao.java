package org.art.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {

    List<E> getAll();
    Optional<E> getById(K id);
    boolean delete (E entity);
    boolean update (E entity);
    boolean create (E entity);
}
