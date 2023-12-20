package com.shibam.swapicacheengine.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shibam.swapicacheengine.cache.SwapiCache;
import com.shibam.swapicacheengine.model.Vehicle;
import com.shibam.swapicacheengine.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final SwapiCache swapiCache;

    @Autowired
    public VehicleController(VehicleService vehicleService, SwapiCache swapiCache) {
        this.vehicleService = vehicleService;
        this.swapiCache = swapiCache;
    }

    @SuppressWarnings("unchecked")
	@GetMapping
    public List<Vehicle> getAllVehicles() {
        // Check if vehicles are already in the cache
        if (swapiCache.containsKey("vehicles")) {
            return (List<Vehicle>) swapiCache.get("vehicles");
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        swapiCache.put("vehicles", vehicles);
        return vehicles;
    }

    @GetMapping("/{name}")
    public Vehicle getVehicleByName(@PathVariable String name) {
        // Check if vehicles are already in the cache
        if (swapiCache.containsKey("vehicles")) {
            @SuppressWarnings("unchecked")
			List<Vehicle> vehicleList = (List<Vehicle>) swapiCache.get("vehicles");

            // Find the vehicle by name in the cached data
            return findVehicleByName(vehicleList, name);
        }

        // If not in the cache, fetch from the service and store in the cache
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        swapiCache.put("vehicles", vehicles);

        // Find the vehicle by name in the fetched data
        return findVehicleByName(vehicles, name);
    }

    private Vehicle findVehicleByName(List<Vehicle> vehicleList, String name) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Additional endpoints, e.g., search vehicles, can be added as needed
}
