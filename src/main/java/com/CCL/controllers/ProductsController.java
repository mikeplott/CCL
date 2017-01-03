package com.CCL.controllers;

import com.CCL.services.BeerRepo;
import com.CCL.services.LiquorRepo;
import com.CCL.services.WineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class ProductsController {

    @Autowired
    BeerRepo beers;

    @Autowired
    LiquorRepo liquors;

    @Autowired
    WineRepo wines;
}
