package com.gp.nut.service;

import com.gp.nut.dto.LocationCreateRequestDTO;
import com.gp.nut.dto.LocationResponseDTO;
import com.gp.nut.dto.LocationUpdateRequestDTO;
import com.gp.nut.entity.Location;
import com.gp.nut.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
//@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationResponseDTO createLocation(LocationCreateRequestDTO request) {

        Location location = new Location();
        location.setName(request.getName());
        location.setAddress(request.getAddress());
        location.setPriceRange(request.getPriceRange());
        location.setDescription(request.getDescription());
        location.setScheduleId(request.getScheduleId());
        location.setRegisteredBy(request.getRegisteredBy());

        Location savedLocation = locationRepository.save(location);

        LocationResponseDTO respons= new LocationResponseDTO();
        respons.setId(savedLocation.getId());
        respons.setName(savedLocation.getName());
        respons.setAddress(savedLocation.getAddress());
        respons.setPriceRange(savedLocation.getPriceRange());
        respons.setDescription(savedLocation.getDescription());
        respons.setScheduleId(savedLocation.getScheduleId());
        respons.setRegisteredBy(savedLocation.getRegisteredBy());
        respons.setCreatedAt(savedLocation.getCreatedAt());

        return respons;
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

    @Override
    public LocationResponseDTO updateLocation(Long id, LocationUpdateRequestDTO request) {

        Location existingLocation = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("장소를 찾을 수 없습니다."));

        existingLocation.setName(request.getName());
        existingLocation.setAddress(request.getAddress());
        existingLocation.setPriceRange(request.getPriceRange());
        existingLocation.setDescription(request.getDescription());

        Location savedLocation = locationRepository.save(existingLocation);

        LocationResponseDTO respons= new LocationResponseDTO();
        respons.setId(savedLocation.getId());
        respons.setName(savedLocation.getName());
        respons.setAddress(savedLocation.getAddress());
        respons.setPriceRange(savedLocation.getPriceRange());
        respons.setDescription(savedLocation.getDescription());
        respons.setScheduleId(savedLocation.getScheduleId());
        respons.setRegisteredBy(savedLocation.getRegisteredBy());
        respons.setCreatedAt(savedLocation.getCreatedAt());

        return respons;
    }

    @Override
    public void deleteLocation(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new RuntimeException("삭제할 장소를 찾을 수 없습니다."));

        locationRepository.delete(location);
    }

    @Override
    public List<LocationResponseDTO> getLocationsBySchedule(Long scheduleId) {
        List<Location> locations = locationRepository.findByScheduleId(scheduleId);

        return locations.stream().map(location -> {
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

    @Override
    public LocationResponseDTO getRandomLocation(Long scheduleId) {

        List<Location> locations = locationRepository.findByScheduleId(scheduleId);

        if(locations.isEmpty()) {
            throw new RuntimeException("해당 스케줄에 등록된 장소가 없습니다.");
        }

        Random random = new Random();
        Location randomLocation = locations.get(random.nextInt(locations.size()));

        LocationResponseDTO respons= new LocationResponseDTO();
        respons.setId(randomLocation.getId());
        respons.setName(randomLocation.getName());
        respons.setAddress(randomLocation.getAddress());
        respons.setPriceRange(randomLocation.getPriceRange());
        respons.setDescription(randomLocation.getDescription());
        respons.setScheduleId(randomLocation.getScheduleId());
        respons.setRegisteredBy(randomLocation.getRegisteredBy());
        respons.setCreatedAt(randomLocation.getCreatedAt());

        return respons;
    }
}
