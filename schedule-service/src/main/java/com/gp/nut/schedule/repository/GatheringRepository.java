package com.gp.nut.schedule.repository;

import com.gp.nut.schedule.entity.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatheringRepository extends JpaRepository<Gathering, Long> {

}
