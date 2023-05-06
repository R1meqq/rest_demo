package com.example.rest_demo.repository;

import com.example.rest_demo.rest.domain.CruiseShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseShipRepository extends JpaRepository<CruiseShip,Integer> {

}
