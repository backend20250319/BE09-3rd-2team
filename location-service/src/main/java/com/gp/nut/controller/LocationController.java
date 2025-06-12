package com.gp.nut.controller;

import com.gp.nut.dto.LocationCreateRequestDTO;
import com.gp.nut.dto.LocationResponseDTO;
import com.gp.nut.entity.Location;
import com.gp.nut.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goodplace/location")
//@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public List<LocationResponseDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/create")
    public LocationResponseDTO createLocation(@RequestBody LocationCreateRequestDTO request) {
        return locationService.createLocation(request);
    }
}
