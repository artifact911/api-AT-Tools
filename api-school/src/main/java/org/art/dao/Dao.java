package org.art.dao;

import java.util.List;

public interface Dao<K, E> {

    List<E> getAll();

    E getById(K id);
}
