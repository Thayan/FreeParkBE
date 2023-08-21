package com.FreePark.service;

import com.FreePark.dto.ParkingDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ParkingServiceImpl implements ParkingService{

    private static final String DATA_FILE_PATH = "src/main/resources/data.json";

    @Override
    public List<ParkingDTO> getParkingSpots(String location) {
        ArrayList<ParkingDTO> parkingSpots = new ArrayList<>();

        try{
            String data = readDataFromFile(DATA_FILE_PATH);

            JSONObject obj = new JSONObject(data);
            JSONArray arr = obj.getJSONArray("parkingSpots");
            int randomNum = ThreadLocalRandom.current().nextInt(0, 990);
            for(int i = randomNum; i < randomNum + 10; i++){
                parkingSpots.add(parseParkingSpot(arr, i));
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return parkingSpots;
    }

    private ParkingDTO parseParkingSpot(JSONArray parkingSpotJson, int i) throws JSONException {

        int id = parkingSpotJson.getJSONObject(i).getInt("id");
        String roadName = parkingSpotJson.getJSONObject(i).getString("road_name");
        String roadSuffix = parkingSpotJson.getJSONObject(i).getString("road_suffix");
        double longitude = parkingSpotJson.getJSONObject(i).getDouble("longitude");
        double latitude = parkingSpotJson.getJSONObject(i).getDouble("latitude");
        float costPerHour = parkingSpotJson.getJSONObject(i).getLong("cost_per_hour");
        Time freeAfter = null;
        Time payFrom = null;

        try {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
            Date freeAfterDate =(Date)format.parse(parkingSpotJson.getJSONObject(i).getString("free_after"));
            Date payFromDate =(Date)format.parse(parkingSpotJson.getJSONObject(i).getString("pay_from"));

            freeAfter = new Time(freeAfterDate.getTime());
            payFrom = new Time(payFromDate.getTime());
        } catch(Exception e) {
            System.out.println("Exception is " + e.toString());
        }


        return new ParkingDTO(id, roadName, roadSuffix, longitude, latitude, costPerHour, freeAfter, payFrom);
    }

    private String readDataFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
