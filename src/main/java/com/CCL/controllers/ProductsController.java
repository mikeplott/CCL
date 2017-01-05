package com.CCL.controllers;

import com.CCL.entities.User;
import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Wine;
import com.CCL.services.BeerRepo;
import com.CCL.services.LiquorRepo;
import com.CCL.services.UserRepo;
import com.CCL.services.WineRepo;
import com.CCL.utlities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

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
    UserRepo users;

    @Autowired
    WineRepo wines;

    @RequestMapping(path = "/create-wine", method = RequestMethod.POST)
    public ResponseEntity<Wine> createWine(HttpSession session, @RequestBody Wine wine) throws PasswordStorage.CannotPerformOperationException {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        if (!User.isLoggedIn(session, user)) {
            return new ResponseEntity<Wine>(HttpStatus.FORBIDDEN);
        }
        wines.save(wine);
        return new ResponseEntity<Wine>(wine, HttpStatus.OK);
    }

    @RequestMapping(path = "/create-beer", method = RequestMethod.POST)
    public ResponseEntity<Beer> createBeer(HttpSession session, @RequestBody Beer beer) throws PasswordStorage.CannotPerformOperationException {
        String userName = (String) session.getAttribute("userName");
        User user = users.findByUserName(userName);
        if (!User.isLoggedIn(session, user)) {
            return new ResponseEntity<Beer>(HttpStatus.FORBIDDEN);
        }
        beers.save(beer);
        return new ResponseEntity<Beer>(HttpStatus.OK);
    }
}
