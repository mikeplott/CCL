package com.CCL.controllers;

import com.CCL.entities.fleet.Vehicle;
import com.CCL.services.FleetRepo;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(path = "add-truck", method = RequestMethod.POST)
    public Vehicle addTruck(HttpSession session, @RequestBody HashMap<String, String> json) {

    }


}
