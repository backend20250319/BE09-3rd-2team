package com.gp.nut.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationUpdateRequestDTO {

    @NotBlank(message = "장소명은 필수입니다.")
    private String name;
    private String address;
    private String priceRange;
    private String description;

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
}
