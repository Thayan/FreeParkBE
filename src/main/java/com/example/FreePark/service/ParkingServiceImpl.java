package com.example.FreePark.service;

import com.example.FreePark.dto.ParkingDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ParkingServiceImpl implements ParkingService{
    @Override
    public List<ParkingDTO> getParkingSpots(String location) {
        ArrayList<ParkingDTO> parkingSpots = new ArrayList<>();

        try{
            String data = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/main/resources/data.json")), StandardCharsets.UTF_8);

            JSONObject obj = new JSONObject(data);
            JSONArray arr = obj.getJSONArray("parkingSpots");
            int randomNum = ThreadLocalRandom.current().nextInt(0, 990);
            for(int i = randomNum; i < randomNum + 10; i++){
                int id = arr.getJSONObject(i).getInt("id");
                String roadName = arr.getJSONObject(i).getString("road_name");
                String roadSuffix = arr.getJSONObject(i).getString("road_suffix");
                double longitude = arr.getJSONObject(i).getDouble("longitude");
                double latitude = arr.getJSONObject(i).getDouble("latitude");
                float costPerHour = arr.getJSONObject(i).getLong("cost_per_hour");
                String freeAfter = arr.getJSONObject(i).getString("free_after");
                String payFrom = arr.getJSONObject(i).getString("pay_from");

                parkingSpots.add(new ParkingDTO(id, roadName, roadSuffix, longitude, latitude, costPerHour, freeAfter, payFrom));
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return parkingSpots;
    }
}
