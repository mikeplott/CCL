package com.CCL.controllers;

import com.CCL.entities.User;
import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Liquor;
import com.CCL.entities.products.Product;
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
    LiquorRepo liquors;

    @Autowired
    ProductRepo products;

    @Autowired
    UserRepo users;

    @Autowired
    WineRepo wines;

    Server h2;

    @PostConstruct
    public void init() throws SQLException, IOException, ParseException, PasswordStorage.CannotPerformOperationException {
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
            String name = columns[6];
            String pass = PasswordStorage.createHash(columns[7]);
            String email = columns[8];
            boolean admin = Boolean.parseBoolean(columns[9]);
            boolean rep = Boolean.parseBoolean(columns[10]);
            boolean driver = Boolean.parseBoolean(columns[11]);
            boolean warehouse = Boolean.parseBoolean(columns[12]);
            boolean valid = Boolean.parseBoolean(columns[13]);

            User user = new User(name, pass, email, admin, rep, driver, warehouse, valid);

            users.save(user);
        }

        if (wines.count() == 0) {
            File wineFile = new File("winedata.csv");
            Scanner scanner = new Scanner(wineFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] wineData = line.split("\\|");
                int vintage = Integer.parseInt(wineData[0]);
                String varietal = wineData[1];
                String color = wineData[2];
                String importer = wineData[3];
                String name = wineData[4];
                String desc = wineData[5];
                String itemCode = wineData[6];
                String origin = wineData[7];
                String volume = wineData[8];
                double frontPrice = Double.valueOf(wineData[9]);
                double tenCP = Double.valueOf(wineData[10]);
                double twentyFCP = Double.valueOf(wineData[11]);
                double cost = Double.valueOf(wineData[12]);
                double bW = Double.valueOf(wineData[13]);
                double cW = Double.valueOf(wineData[14]);
                int quant = Integer.parseInt(wineData[15]);
                boolean isEx;
                boolean isDual;
                int ex = Integer.parseInt(wineData[16]);
                int dual = Integer.parseInt(wineData[17]);
                if (ex == 0) {
                    isEx = true;
                }
                else {
                    isEx = false;
                }
                if (dual == 0) {
                    isDual = true;
                }
                else isDual = false;
                Wine.caseSize caseSize = Wine.caseSize.valueOf(wineData[18]);

                Wine wine = new Wine(vintage, varietal, color, importer, name, desc, itemCode, origin, volume,
                        frontPrice, tenCP, twentyFCP, cost, bW, cW, quant, isEx, isDual, caseSize);
                wines.save(wine);

                Wine wineFromDb = wines.findByName(name);

                Product product = new Product(wineFromDb.getId(), name, desc, itemCode, origin, volume,
                        frontPrice, tenCP, twentyFCP, cost, bW, cW, quant, isEx,  isDual, vintage, varietal, color,
                        importer, caseSize, false, false, true);

                products.save(product);
            }
        }

        if (liquors.count() == 0) {
            File liquorFile = new File("liquordata.csv");
            Scanner scanner = new Scanner(liquorFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] liqData = line.split("\\|");
                String type = liqData[0];
                String distillery = liqData[1];
                String name = liqData[2];
                String desc = liqData[3];
                String itemCode = liqData[4];
                String origin = liqData[5];
                String volume = liqData[6];
                double frontPrice = Double.valueOf(liqData[7]);
                double tenCP = Double.valueOf(liqData[8]);
                double twentyFCP = Double.valueOf(liqData[9]);
                double cost = Double.valueOf(liqData[10]);
                double bW = Double.valueOf(liqData[11]);
                double cW = Double.valueOf(liqData[12]);
                int quant = Integer.parseInt(liqData[13]);
                boolean isEx;
                boolean isDual;
                int ex = Integer.parseInt(liqData[14]);
                int dual = Integer.parseInt(liqData[15]);
                if (ex == 0) {
                    isEx = true;
                }
                else {
                    isEx = false;
                }
                if (dual == 0) {
                    isDual = true;
                }
                else isDual = false;
                Liquor.caseSize caseSize = Liquor.caseSize.valueOf(liqData[16]);

                Liquor liquor = new Liquor(type, distillery, name, desc, itemCode, origin, volume, frontPrice,
                        tenCP, twentyFCP, cost, bW, cW, quant, isEx, isDual, caseSize);

                liquors.save(liquor);

                Liquor liquorFromDb = liquors.findByName(name);

                Product product = new Product(liquorFromDb.getId(), name, desc, itemCode, origin, volume,
                        frontPrice, tenCP, twentyFCP, cost, bW, cW, quant, isEx, isDual, type, distillery, caseSize,
                        false, true, false);

                products.save(product);
            }
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

                Beer beerFromDb = beers.findByName(name);

                Product product = new Product(beerFromDb.getId(), name, desc, itemCode, origin, volume, frontPrice, tenCasePrice, twentyFiveCasePrice,
                        cost, bottleWeight, caseWeight, quantity, isExclusive, isDualState, lotDate, expDate, beerType, brewery, isDomestic, isSeasonal, caseSize,
                        false, true, false);

                products.save(product);
            }
        }
    }

    @PreDestroy
    public void destroy() {
        h2.stop();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> userLogin(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        User userFromDB = users.findByUserName(user.getUserName());
        if (User.userValidation(user, userFromDB, session)) {
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
        PasswordStorage.createHash(userForDB.getPassword());
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

