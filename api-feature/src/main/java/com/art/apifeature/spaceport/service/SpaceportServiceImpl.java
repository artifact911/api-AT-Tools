package com.art.apifeature.spaceport.service;

import com.art.apifeature.spaceport.dto.GetAllSpaceport;
import com.art.apifeature.spaceport.repository.SpaceportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceportServiceImpl implements SpaceportService {

    private final SpaceportRepository spaceportRepository;

    @Autowired
    public SpaceportServiceImpl(SpaceportRepository spaceportRepository) {
        this.spaceportRepository = spaceportRepository;
    }

    @Override
    public GetAllSpaceport getAllSpaceport() {
        return new GetAllSpaceport(spaceportRepository.getAll());
    }
}
