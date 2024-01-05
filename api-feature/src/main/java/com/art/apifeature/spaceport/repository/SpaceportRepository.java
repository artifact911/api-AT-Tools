package com.art.apifeature.spaceport.repository;

import com.art.apifeature.CrudFeatureRepository;
import com.art.apifeature.spaceport.transport.Spaceport;
import com.art.apifeature.spaceport.util.random_generator.GenerateSpaceport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpaceportRepository implements CrudFeatureRepository<Integer, Spaceport> {

    @Override
    public List<Spaceport> getAll() {
        return GenerateSpaceport.getSpaceportList();
    }
}
