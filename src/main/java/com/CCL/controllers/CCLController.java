package com.CCL.controllers;

import com.CCL.entities.User;
import com.CCL.services.UserRepo;
import com.CCL.utlities.PasswordStorage;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by michaelplott on 1/3/17.
 */
@RestController
public class CCLController {

    @Autowired
    public static UserRepo users;

    Server h2;

    @PostConstruct
    public void init() throws SQLException {
        h2.createWebServer().start();
    }

    @PreDestroy
    public void destroy() {
        h2.stop();
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> userLogin(HttpSession session, @RequestBody User user) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        if (User.userValidation(user)) {
            User userFromDB = users.findByUserName(user.getUserName());
            session.setAttribute("userName", user.getUserName());
            return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ResponseEntity<User> userSignUp(HttpSession session, @RequestBody User user) {
        if (!User.isValidUser(user)) {
            return new ResponseEntity<User>(HttpStatus.FORBIDDEN);
        }
        session.setAttribute("userName", user.getUserName());
        User.userEmailValidation(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
