package com.art.apifeature.dto;

import com.art.apifeature.model.transport.Spaceport;

import java.util.List;

public record GetAllSpaceport(List<Spaceport> spaceportList) {
}
