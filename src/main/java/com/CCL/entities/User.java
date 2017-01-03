package com.CCL.entities;

import com.CCL.utlities.PasswordStorage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.*;
import java.util.Properties;

import static com.CCL.controllers.CCLController.users;


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
    private boolean isValid;

    public User() {
    }

    public User(String userName, String password, String email, boolean isAdmin, boolean isValid) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
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

    public static boolean userValidation(User user) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {
        if (user.getUserName() == null || user.getPassword() == null) {
            return false;
        }
        User userFromDB = users.findByUserName(user.getUserName());
        if (userFromDB == null) {
            return false;
        }
        if (!PasswordStorage.verifyPassword(user.getPassword(), userFromDB.getPassword())) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean isValidUser(User user) throws PasswordStorage.CannotPerformOperationException {
        if (user.getUserName() == null || user.getPassword() == null || user.getEmail() == null) {
            return false;
        }
        if (!user.getEmail().contains("@")) {
            return false;
        }
        else {
            User userForDB = new User(user.getUserName(), PasswordStorage.createHash(user.getPassword()), user.getEmail(), false, true);
            users.save(user);
            return true;
        }
    }

    public static void userEmailValidation(User user) {
        String to = user.getEmail();
        String from = "CCLmike88@gmail.com";
        String host = "localhost";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("CCL User Validation");
            message.setText("Please click this link below to activate your user account, http://localhost:8080/validate.html?userName=" + user.getUserName());
            Transport.send(message);
        }
        catch (AddressException e) {
            e.printStackTrace();
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
