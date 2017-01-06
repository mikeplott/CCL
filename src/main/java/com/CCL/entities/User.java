package com.CCL.entities;

import com.CCL.controllers.CCLController;
import com.CCL.utlities.PasswordStorage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean isAdmin;

    @Column(nullable = false)
    private boolean isSalesRep;

    @Column(nullable = false)
    private boolean isDriver;

    @Column(nullable = false)
    private boolean isWarehouseWorker;

    @Column(nullable = false)
    private boolean isValid;

    public User() {
    }

    public User(String userName, String password, String email, boolean isAdmin, boolean isSalesRep, boolean isDriver, boolean isWarehouseWorker, boolean isValid) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isSalesRep = isSalesRep;
        this.isDriver = isDriver;
        this.isWarehouseWorker = isWarehouseWorker;
        this.isValid = isValid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public static boolean userValidation(User user, User userFromDB, HttpSession session) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {
        if (user.getUserName() == null || user.getPassword() == null) {
            return false;
        }
        else if (userFromDB == null) {
            return false;
        }
        else if (!PasswordStorage.verifyPassword(user.getPassword(), userFromDB.getPassword())) {
            return false;
        }
        else if (!userFromDB.isValid) {
            return false;
        }
        else {
            session.setAttribute("userName", user.getUserName());
            return true;
        }
    }

    public static boolean isLoggedIn(User user) {
        if (user != null && user.isValid) {
            return true;
        }
        return false;
    }

    public static User isValidUser(User user) throws PasswordStorage.CannotPerformOperationException {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null) {
            return null;
        }
        if (!user.getEmail().contains("@")) {
            return null;
        }
        else {
            User userForDB = new User(user.getUserName(), PasswordStorage.createHash(user.getPassword()), user.getEmail(),
                    false, false, false, false, true);
            return userForDB;
        }
    }

    public static void userEmailValidation(User user) throws UnsupportedEncodingException, MessagingException {
        String to = user.getEmail();
        String theName = user.getUserName();
        String userName = URLEncoder.encode(theName, "UTF-8");

        Properties props = System.getProperties();
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props, null);
        MimeMessage message = new MimeMessage(session);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Account Validation");
        message.setContent("Click the link below to validate" + " " + " " + "http://localhost:8080/validate?userName=" +
                userName, "text/html");

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", CCLController.from, CCLController.auth);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

}
