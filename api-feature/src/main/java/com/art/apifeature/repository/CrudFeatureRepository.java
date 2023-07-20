package com.art.apifeature.repository;

import java.util.List;

public interface CrudFeatureRepository<K, E> {

    List<E> getAll();
}
