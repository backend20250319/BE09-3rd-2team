package com.gp.nut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository extends JpaRepository<Location, Long> {
}
