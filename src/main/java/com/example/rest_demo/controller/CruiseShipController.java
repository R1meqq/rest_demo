package com.example.rest_demo.controller;

import com.example.rest_demo.rest.domain.CruiseShip;
import com.example.rest_demo.service.CruiseShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ships")
public class CruiseShipController {

    @Autowired
    private CruiseShipService cruiseShipService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CruiseShip> getAll(){
        return cruiseShipService.findAllShips();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CruiseShip getById(@PathVariable Integer id){
        return cruiseShipService.findById(id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public CruiseShip createShip(@RequestBody CruiseShip cruiseShip){
        return cruiseShipService.createShip(cruiseShip);
    }

    @PutMapping("/{id}")
    public CruiseShip update(@PathVariable Integer id, @RequestBody CruiseShip cruiseShip){
        return cruiseShipService.update(id,cruiseShip);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<CruiseShip> delete(@PathVariable Integer id){
       return cruiseShipService.deleteShipById(id);
    }
}
