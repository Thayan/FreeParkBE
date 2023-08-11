package com.FreePark.service;

import com.FreePark.dto.ParkingDTO;

import java.util.List;

public interface ParkingService {
    List<ParkingDTO> getParkingSpots(String location);
}
