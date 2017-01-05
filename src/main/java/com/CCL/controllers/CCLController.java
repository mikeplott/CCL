package com.CCL.controllers;

import com.CCL.entities.User;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

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
    UserRepo users;

    @Autowired
    WineRepo wines;

    Server h2;

    @PostConstruct
    public void init() throws SQLException, FileNotFoundException {
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

        if (wines.findAll().size() == 0) {
            Wine wine = new Wine(2017, "Picpoul Blanc", "White", "Kysela Pere et Fils",
                    "Hughes Picpoul", "Picpoul", "kys-643", "France", 750 + "",
                    9.99, 8.99, 7.99, 5.99, 3, 36,
                    12000, false, true, Wine.wineCaseSize.TWELVE_PACK);

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
        if (User.userValidation(user, userFromDB)) {
            session.setAttribute("userName", user.getUserName());
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
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
            session.setAttribute("userName", userFromDB.getUserName());
            response.sendRedirect("dashboard.html");
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
        }
    }
}

