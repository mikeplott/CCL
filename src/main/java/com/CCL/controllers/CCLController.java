package com.CCL.controllers;

import com.CCL.entities.User;
import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Wine;
import com.CCL.services.*;
import com.CCL.utlities.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class CCLController {

    public static String from;

    public static String auth;

    public static String placesApiKey;

    public static String distanceApiKey;

    public static String mapsJSApiKey;

    public static String embeddedMapsApiKey;

    @Autowired
    BeerRepo beers;

    @Autowired
    UserRepo users;

    @Autowired
    WineRepo wines;

    Server h2;

    @PostConstruct
    public void init() throws SQLException, IOException, ParseException {
        h2.createWebServer().start();

        File f = new File("info.csv");
        Scanner fileReader = new Scanner(f);
        while (fileReader.hasNext()) {
            String line = fileReader.nextLine();
            String[] columns = line.split(",");
            from = columns[0];
            auth = columns[1];
            placesApiKey = columns[2];
            distanceApiKey = columns[3];
            mapsJSApiKey = columns[4];
            embeddedMapsApiKey = columns[5];
        }

        if (beers.count() == 0) {
            File c = new File("beerdata.csv");
            Scanner fr = new Scanner(c);
            while (fr.hasNext()) {
                String line = fr.nextLine();
                String[] columns = line.split("\\|");
                String lot = columns[0];
                SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
                Date parsed = format.parse(lot);
                java.sql.Date lotDate = new java.sql.Date(parsed.getTime());
                String exp = columns[1];
                Date parsed1 = format.parse(exp);
                java.sql.Date expDate = new java.sql.Date(parsed1.getTime());
                String beerType = columns[2];
                String brewery = columns[3];
                boolean isDomestic = Boolean.getBoolean(columns[4]);
                boolean isSeasonal = Boolean.getBoolean(columns[5]);
                String name = columns[6];
                String desc = columns[7];
                String itemCode = columns[8];
                String origin = columns[9];
                String volume = columns[10];
                double frontPrice = Double.valueOf(columns[11]);
                double tenCasePrice = Double.valueOf(columns[12]);
                double twentyFiveCasePrice = Double.valueOf(columns[13]);
                double cost = Double.valueOf(columns[14]);
                double bottleWeight = Double.valueOf(columns[15]);
                double caseWeight = Double.valueOf(columns[16]);
                int quantity = Integer.parseInt(columns[17]);
                boolean isExclusive = Boolean.getBoolean(columns[18]);
                boolean isDualState = Boolean.getBoolean(columns[19]);
                Beer.caseSize caseSize = Beer.caseSize.valueOf(columns[20]);
                Beer beer = new Beer(lotDate, expDate, beerType, brewery, isDomestic, isSeasonal, name, desc, itemCode, origin, volume, frontPrice,
                        tenCasePrice, twentyFiveCasePrice, cost, bottleWeight, caseWeight, quantity, isExclusive, isDualState, caseSize);
                beers.save(beer);
            }
        }

        if (wines.findAll().size() == 0) {
            Wine wine = new Wine(2017, "Picpoul Blanc", "White", "Kysela Pere et Fils",
                    "Hughes Picpoul", "Picpoul", "kys-643", "France", 750 + "",
                    9.99, 8.99, 7.99, 5.99, 3, 36,
                    12000, false, true, Wine.caseSize.TWELVE_PACK);
            wines.save(wine);
        }
    }

    @PreDestroy
    public void destroy() {
        h2.stop();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> userLogin(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        User userFromDB = users.findByUserName(user.getUserName());
        System.out.println(user);
        if (User.userValidation(user, userFromDB, session)) {
//            session.setAttribute("userName", user.getUserName());
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ResponseEntity<User> userSignUp(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, UnsupportedEncodingException, MessagingException {
        User userForDB = users.findByUserName(user.getUserName());
        if (userForDB != null) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        userForDB = User.isValidUser(user);
        if (userForDB == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        users.save(userForDB);
        session.setAttribute("userName", userForDB.getUserName());
        User.userEmailValidation(user);
        return new ResponseEntity<User>(userForDB, HttpStatus.OK);
    }

    @RequestMapping(path = "/validate", method = RequestMethod.GET)
    public ResponseEntity<User> validUser(HttpSession session, String userName, HttpServletResponse response) throws IOException {
        if (userName == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        User userFromDB = users.findByUserName(userName);
        if (userFromDB == null) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        else {
            userFromDB.setValid(true);
            users.save(userFromDB);
            session.setAttribute("userName", userFromDB.getUserName());
            response.sendRedirect("dashboard.html");
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
        }
    }
}

