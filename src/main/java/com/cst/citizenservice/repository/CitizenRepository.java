package com.cst.citizenservice.repository;

import com.cst.citizenservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    public List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);
}
