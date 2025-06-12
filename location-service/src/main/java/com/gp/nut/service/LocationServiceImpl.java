package com.gp.nut.service;

import com.gp.nut.dto.LocationCreateRequestDTO;
import com.gp.nut.dto.LocationResponseDTO;
import com.gp.nut.entity.Location;
import com.gp.nut.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public LocationResponseDTO createLocation(LocationCreateRequestDTO request) {
        return null;
    }

    @Override
    public List<LocationResponseDTO> getAllLocations() {

        List<Location> locations = locationRepository.findAll();

        return locations.stream()
                .map(location -> {
                    LocationResponseDTO dto = new LocationResponseDTO();
                    dto.setId(location.getId());
                    dto.setName(location.getName());
                    dto.setAddress(location.getAddress());
                    dto.setPriceRange(location.getPriceRange());
                    dto.setDescription(location.getDescription());
                    dto.setScheduleId(location.getScheduleId());
                    dto.setRegisteredBy(location.getRegisteredBy());
                    dto.setCreatedAt(location.getCreatedAt());
                    return dto;
                })
                .toList();
    }
}
