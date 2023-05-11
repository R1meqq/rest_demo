package com.example.rest_demo.service;

import com.example.rest_demo.rest.domain.CruiseShip;
import org.jvnet.hk2.annotations.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Component
public class CruiseShipService {

    private final Map<Integer,CruiseShip> shipHashMap = new HashMap<>();

    private final AtomicInteger idCounter = new AtomicInteger();

    public List<CruiseShip> findAllShips() {
        return new LinkedList<CruiseShip>(shipHashMap.values());
    }

    public CruiseShip findById(Integer shipId){
        return shipHashMap.get(shipId);
    }

    public CruiseShip createShip(CruiseShip cruiseShip) {

        cruiseShip.setId(idCounter.incrementAndGet());
        shipHashMap.put(cruiseShip.getId(),cruiseShip);
        return cruiseShip;
    }


    public CruiseShip update(Integer cruiseId,CruiseShip cruiseShip){
        CruiseShip cruiseShip1 = shipHashMap.get(cruiseId);
        cruiseShip1.setName(cruiseShip.getName());
        cruiseShip1.setCurrentPort(cruiseShip.getCurrentPort());
        cruiseShip1.setMaxSpeed(cruiseShip.getMaxSpeed());
        cruiseShip1.setMaxCapacity(cruiseShip.getMaxCapacity());
        cruiseShip1.setCurrentLoad(cruiseShip.getCurrentLoad());
        cruiseShip1.setCrewCount(cruiseShip.getCrewCount());
        cruiseShip1.setPassengersCount(cruiseShip.getPassengersCount());
        shipHashMap.put(cruiseId,cruiseShip1);
        return cruiseShip1;
    }

    public ResponseEntity<CruiseShip> deleteShipById(Integer shipId){
        HttpStatus status = shipHashMap.remove(shipId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }
}
