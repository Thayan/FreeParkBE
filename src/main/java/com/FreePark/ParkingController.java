package com.FreePark;

import com.FreePark.service.ParkingServiceImpl;
import com.FreePark.dto.ParkingDTO;
import com.FreePark.service.ParkingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {

    @RequestMapping(value = "/parking", method = RequestMethod.GET)
    @ResponseBody
    public List<ParkingDTO> getLocation(@PathVariable(value = "location") String location)
    {
        ParkingService parkingService = new ParkingServiceImpl();
        return parkingService.getParkingSpots(location);
    }
}
