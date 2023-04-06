package org.art.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudRepository<K, E> {

    List<E> getAll();

    Optional<E> getById(K id);

    boolean delete(E entity);

    boolean update(E entity);

    boolean create(E entity);
}
