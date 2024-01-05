package com.art.apifeature;

import java.util.List;

public interface CrudFeatureService<K, E> {

    List<E> getAll();

    E findById(K id);
}
