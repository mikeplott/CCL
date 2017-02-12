package com.CCL.controllers;

import com.CCL.entities.api_access.User;
import com.CCL.entities.fleet.Vehicle;
import com.CCL.services.FleetRepo;
import com.CCL.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by michaelplott on 2/6/17.
 */
public class FleetController {

    @Autowired
    FleetRepo fleet;

    @Autowired
    UserRepo users;

    @RequestMapping(path = "/add-truck", method = RequestMethod.POST)
    public ResponseEntity<Vehicle> addTruck(HttpSession session, @RequestBody HashMap<String, String> json) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        User.isLoggedIn(user);
        System.out.println(json.get("make"));
        System.out.println(json.get("model"));
        int year = Integer.parseInt(json.get("year"));
        long mileage = Long.parseLong(json.get("mileage"));
        String warInfo = json.get("warInfo");
        boolean hasWarranty = false;
        if (warInfo != null) {
            hasWarranty = true;
        }
        Vehicle vehicle = new Vehicle(json.get("make"), json.get("model"), year, mileage, json.get("fueltype"),
                warInfo, json.get("vin"), json.get("plate"), hasWarranty);

        fleet.save(vehicle);
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
    }


}
