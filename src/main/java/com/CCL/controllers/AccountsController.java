package com.CCL.controllers;

import com.CCL.services.CreditRepo;
import com.CCL.services.InvoiceRepo;
import com.CCL.services.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelplott on 1/3/17.
 */
//@ComponentScan(basePackages = {"com.CCL.services"})
@RestController
public class AccountsController {

    @Autowired
    //@Qualifier("myCredits")
    CreditRepo credits;

    @Autowired
//    @Qualifier("myh2JdbcTemplate")
    InvoiceRepo invoices;

    @Autowired
//    @Qualifier("myh2JdbcTemplate")
    OrderRepo orders;

    
}
