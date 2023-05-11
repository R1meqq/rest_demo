package com.example.rest_demo.rest.domain;


import lombok.*;


@Setter
@Getter
@AllArgsConstructor
public class CruiseShip {
    asd
    asd
            asd
    

    private Integer id;

    private String name;

    private String currentPort;

    private double maxSpeed;

    private double maxCapacity;

    private double currentLoad;

    private int crewCount;

    private int passengersCount;

    public CruiseShip(final String name,final String currentPort,final double maxSpeed,final double maxCapacity,
                      final double currentLoad,final int crewCount,final  int passengersCount) {
        this.name = name;
        this.currentPort = currentPort;
        this.maxSpeed = maxSpeed;
        this.maxCapacity = maxCapacity;
        this.currentLoad = currentLoad;
        this.crewCount = crewCount;
        this.passengersCount = passengersCount;
    }

    public CruiseShip(){
        ;
    }

}