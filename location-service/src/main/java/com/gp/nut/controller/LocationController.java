package com.gp.nut.controller;

import com.gp.nut.dto.LocationResponseDTO;
import com.gp.nut.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/goodplace/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/list")
    public List<LocationResponseDTO> getAllLocations() {
        return locationService.getAllLocations();
    }
}
