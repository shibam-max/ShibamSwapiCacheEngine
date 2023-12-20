package com.shibam.swapicacheengine.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shibam.swapicacheengine.model.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final RestTemplate restTemplate;

    @Autowired
    public VehicleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Vehicle> getAllVehicles() {
        String url = "https://swapi.dev/api/vehicles/";
        Vehicle[] vehiclesArray = restTemplate.getForObject(url, Vehicle[].class);
        return Arrays.asList(vehiclesArray);
    }

    public Optional<Vehicle> getVehicleByName(String name) {
        List<Vehicle> vehicles = getAllVehicles();
        return findVehicleByName(vehicles, name);
    }

    private Optional<Vehicle> findVehicleByName(List<Vehicle> vehicleList, String name) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getName() != null && vehicle.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
