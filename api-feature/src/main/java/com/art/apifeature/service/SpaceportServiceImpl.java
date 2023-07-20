package com.art.apifeature.service;

import com.art.apifeature.dto.GetAllSpaceport;
import com.art.apifeature.repository.SpaceportRepository;
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
