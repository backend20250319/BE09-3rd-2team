package com.gp.nut.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LocationResponseDTO {

    private Long id;
    private String name;
    private String address;
    private String priceRange;
    private String description;
    private Long scheduleId;
    private Long registeredBy;
    private LocalDateTime createdAt;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPriceRange() {
//        return priceRange;
//    }
//
//    public void setPriceRange(String priceRange) {
//        this.priceRange = priceRange;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Long getScheduleId() {
//        return scheduleId;
//    }
//
//    public void setScheduleId(Long scheduleId) {
//        this.scheduleId = scheduleId;
//    }
//
//    public Long getRegisteredBy() {
//        return registeredBy;
//    }
//
//    public void setRegisteredBy(Long registeredBy) {
//        this.registeredBy = registeredBy;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
}
