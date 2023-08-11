package com.example.FreePark.service;

import com.example.FreePark.dto.ParkingDTO;

import java.util.List;

public interface ParkingService {
    List<ParkingDTO> getParkingSpots(String location);
}
