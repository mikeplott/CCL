package com.CCL.controllers;

import com.CCL.services.CreditRepo;
import com.CCL.services.InvoiceRepo;
import com.CCL.services.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class AccountsController {

    @Autowired
    CreditRepo credits;

    @Autowired
    InvoiceRepo invoices;

    @Autowired
    OrderRepo orders;

    
}
