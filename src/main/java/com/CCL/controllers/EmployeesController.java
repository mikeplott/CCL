package com.CCL.controllers;

import com.CCL.services.DriverRepo;
import com.CCL.services.OfficeRepRepo;
import com.CCL.services.SalesRepRepo;
import com.CCL.services.WarehouseRepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class EmployeesController {

    @Autowired
    DriverRepo drivers;

    @Autowired
    OfficeRepRepo officereps;

    @Autowired
    SalesRepRepo salesreps;

    @Autowired
    WarehouseRepRepo warehousereps;
}
