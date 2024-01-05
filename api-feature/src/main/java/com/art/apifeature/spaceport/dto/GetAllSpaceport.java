package com.art.apifeature.spaceport.dto;

import com.art.apifeature.spaceport.transport.Spaceport;

import java.util.List;

public record GetAllSpaceport(List<Spaceport> spaceportList) {
}
