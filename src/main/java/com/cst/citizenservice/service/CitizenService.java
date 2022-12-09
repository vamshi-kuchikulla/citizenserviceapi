package com.cst.citizenservice.service;

import com.cst.citizenservice.entity.Citizen;
import com.cst.citizenservice.repository.CitizenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CitizenService {

    private final CitizenRepository citizenRepository;
    public Citizen addCitizen(Citizen citizen) {
          return citizenRepository.save(citizen);
    }

    public List<Citizen> getCitizensById(int vaccinationCenterId) {
        return citizenRepository.findByVaccinationCenterId(vaccinationCenterId);
    }
}
