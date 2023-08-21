package com.FreePark.controllers;

import com.FreePark.service.ParkingServiceImpl;
import com.FreePark.dto.ParkingDTO;
import com.FreePark.service.ParkingService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ParkingController {

    ParkingService parkingService;
    public ParkingController(ParkingService parkingService)
    {
        this.parkingService = parkingService;
    }

    @GetMapping(value = "/parking/{location}")
    @ResponseBody
    public List<ParkingDTO> getLocation(@PathVariable(value = "location") String location)
    {
        return this.parkingService.getParkingSpots(location);
    }
}
