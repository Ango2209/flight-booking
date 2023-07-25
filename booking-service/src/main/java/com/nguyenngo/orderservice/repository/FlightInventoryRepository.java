package com.nguyenngo.orderservice.repository;

import com.nguyenngo.orderservice.dto.TotalInventory;
import com.nguyenngo.orderservice.model.Flight_Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FlightInventoryRepository extends JpaRepository<Flight_Inventory,Long> {
    @Query("SELECT fi FROM Flight_Inventory fi WHERE fi.flight_id = :flightId")
    Flight_Inventory findByFlightId(Long flightId);
    @Transactional
    @Modifying
    @Query("UPDATE Flight_Inventory f SET f.total_inventory = f.total_inventory - 1 WHERE f.flight_id = :flightId AND f.total_inventory > 0")
    void decreaseTotalInventory(Long flightId);
}
