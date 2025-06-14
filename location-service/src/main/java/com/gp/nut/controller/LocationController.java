package com.gp.nut.controller;

import com.gp.nut.dto.LocationCreateRequestDTO;
import com.gp.nut.dto.LocationResponseDTO;
import com.gp.nut.dto.LocationUpdateRequestDTO;
import com.gp.nut.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LocationController {

    @GetMapping("/test")
    public String test() {
        return "Hello from Location Service!";
    }

//    @GetMapping("/")
//    public String home() {
//        return "Location Service is running!";
//    }

    private final LocationService locationService;
//
//    @GetMapping("/list")
//    public List<LocationResponseDTO> getAllLocations() {
//        return locationService.getAllLocations();
//    }
//
//    @PostMapping("/create")
//    public LocationResponseDTO createLocation(@RequestBody LocationCreateRequestDTO request) {
//        return locationService.createLocation(request);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<LocationResponseDTO> updateLocation(@PathVariable Long id, @RequestBody LocationUpdateRequestDTO request) {
//        LocationResponseDTO response = locationService.updateLocation(id, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
//        locationService.deleteLocation(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/schedule/{scheduleId}")
//    public ResponseEntity<List<LocationResponseDTO>> getLocationsByScheduleId(@PathVariable Long scheduleId) {
//        List<LocationResponseDTO> locations = locationService.getLocationsBySchedule(scheduleId);
//        return ResponseEntity.ok(locations);
//    }
//
//    @GetMapping("/schedule/{scheduleId}/random")
//    public ResponseEntity<LocationResponseDTO> getRandomLocation(@PathVariable Long scheduleId) {
//        LocationResponseDTO response = locationService.getRandomLocation(scheduleId);
//        return ResponseEntity.ok(response);
//    }
}
