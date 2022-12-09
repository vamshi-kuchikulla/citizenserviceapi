package com.cst.citizenservice.controller;

import com.cst.citizenservice.entity.Citizen;
import com.cst.citizenservice.service.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/citizenApi")
@AllArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @RequestMapping(value = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen){
        Citizen citizen1 = citizenService.addCitizen(citizen);
        return new ResponseEntity<>(citizen1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getById/{id}")
    public ResponseEntity<List<Citizen>> getCitizensById(@PathVariable int  id){
        List<Citizen> citizenslist = citizenService.getCitizensById(id);
        return new ResponseEntity<>(citizenslist, HttpStatus.CREATED);
    }
}
