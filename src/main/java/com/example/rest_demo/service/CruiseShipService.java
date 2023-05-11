package com.example.rest_demo.service;

import com.example.rest_demo.rest.domain.CruiseShip;
import com.example.rest_demo.exeption.SpringShipException;
import com.example.rest_demo.repository.CruiseShipRepository;
import jakarta.transaction.Transactional;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class CruiseShipService {

    @Autowired
    private CruiseShipRepository cruiseShipRepository;

    private final Map<CruiseShip,Integer> cruiseShipIntegerMap = new HashMap<>();

    public List<CruiseShip> findAllShips() {
        return cruiseShipRepository.findAll();
    }

    public CruiseShip findById(Integer shipId){
        return cruiseShipRepository.findById(shipId).orElseThrow(
                () -> new IllegalArgumentException("Cannot find cruise ship by id - " + shipId));
    }

    @Transactional
    public CruiseShip createShip(CruiseShip cruiseShip) {
        return cruiseShipRepository.save(cruiseShip);
    }

    @Transactional
    public CruiseShip update(Integer cruiseId,CruiseShip newShip){
        CruiseShip savedShip = cruiseShipRepository.findById(newShip.getId()).
                orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));

        savedShip.setName(newShip.getName());
        savedShip.setCurrentPort(newShip.getCurrentPort());
        savedShip.setMaxSpeed(newShip.getMaxSpeed());
        savedShip.setMaxCapacity(newShip.getMaxCapacity());
        savedShip.setCurrentLoad(newShip.getCurrentLoad());
        savedShip.setCrewCount(newShip.getCrewCount());
        savedShip.setPassengersCount(newShip.getPassengersCount());
        cruiseShipRepository.save(savedShip);
        return savedShip;
    }

    public void deleteShipById(Integer shipId){
        cruiseShipRepository.deleteById(shipId);
    }

}
