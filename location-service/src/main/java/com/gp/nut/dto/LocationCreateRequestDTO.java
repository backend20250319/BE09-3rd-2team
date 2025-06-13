package com.gp.nut.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocationCreateRequestDTO {

    @NotBlank(message = "장소명은 필수입니다.")
    private String name;

    @NotNull(message = "주소는 필수입니다.")
    private String address;

    private String priceRange;
    private String description;

    @NotNull(message = "스케줄 ID는 필수입니다.")
    private Long scheduleId;

    @NotNull(message = "등록자 ID는 필수입니다.")
    private Long registeredBy;

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
}
