package com.art.apifeature;

import java.util.List;

public interface CrudFeatureRepository<K, E> {

    List<E> getAll();
}
