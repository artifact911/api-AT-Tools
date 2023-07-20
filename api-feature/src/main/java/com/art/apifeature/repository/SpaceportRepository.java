package com.art.apifeature.repository;

import com.art.apifeature.model.transport.Spaceport;
import com.art.apifeature.util.random_generator.GenerateSpaceport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpaceportRepository implements CrudFeatureRepository<Integer, Spaceport> {

    @Override
    public List<Spaceport> getAll() {
        return GenerateSpaceport.getSpaceportList();
    }
}
